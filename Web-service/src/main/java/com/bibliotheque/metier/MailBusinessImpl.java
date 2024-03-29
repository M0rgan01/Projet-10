package com.bibliotheque.metier;

import java.security.SecureRandom;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.MailRepository;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;
import com.bibliotheque.utilities.Jasypt;
import com.bibliotheque.utilities.SendMail;

@Service
public class MailBusinessImpl implements MailBusiness {

	@Autowired
	private MailRepository mailRepository;
	@Autowired
	private Jasypt encrypt;
	@Autowired
	private SendMail sendMail;
	@Value("${mail.username}")
	private String emailUsers;
	@Value("${mail.password}")
	private String emailPassword;
	@Value("${mail.object.recovery}")
	private String objectRecovery;
	@Value("${mail.body.recovery}")
	private String bodyRecovery;

	@Value("${mail.expirationToken}")
	private int expirationToken;

	private static final Logger logger = LoggerFactory.getLogger(MailBusinessImpl.class);

	@Override
	public Mail saveMail(Mail mail, Long user_id) throws BibliothequeException {
		Mail mail2 = getMailByUserID(user_id);

		// si le nouveau email n'est pas égal à l'ancien
		if (!mail2.getEmail().equals(mail.getEmail())) {
			// validation de l'email
			validateMail(mail);
			// mise à jour
			mail2.setEmail(mail.getEmail());
			logger.info("Update email for mail " + mail2.getId());
			return mailRepository.save(mail2);
		}
		return mail2;
	}

	@Override
	public Mail getMailByUserID(Long id) {
		logger.info("Get mail for user ID " + id);
		return mailRepository.findByUserID(id);
	}

	@Override
	public Mail getMail(String email) {
		logger.info("Get mail for email " + email);
		return mailRepository.findByEmail(email);
	}

	@Override
	public Mail createMail(Mail mail, User user) throws BibliothequeException {
		// validation
		validateMail(mail);
		// attribution de l'utilisateur
		mail.setUser(user);
		logger.info("Create mail " + mail.getEmail());
		// création
		return mailRepository.save(mail);
	}

	@Override
	public void validateMail(Mail mail) throws BibliothequeException {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Mail>> violations = validator.validate(mail);

		for (ConstraintViolation<Mail> violation : violations) {
			logger.error("Mail " + violation.getPropertyPath() + " incorrect : " + violation.getMessage());
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultString(violation.getMessage());

			throw new BibliothequeException(violation.getMessage(), bibliothequeFault);
		}

		Mail mail2 = getMail(mail.getEmail());

		if (mail2 != null) {
			logger.error("Email " + mail.getEmail() + " already exist");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("7");
			bibliothequeFault.setFaultString("mail.email.already.exist");

			throw new BibliothequeException("mail.email.already.exist", bibliothequeFault);
		}
	}

	@Override
	public void sendToken(String email) throws BibliothequeException {

		Mail mail = mailRepository.findByEmail(email);

		if (mail == null) {
			logger.error("Email " + email + " not correct");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("8");
			bibliothequeFault.setFaultString("mail.email.not.correct");

			throw new BibliothequeException("mail.email.not.correct", bibliothequeFault);

		} else if (!mail.getUser().isActive()) {
			logger.error("User account " + mail.getUser().getId() + " not active");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("9");
			bibliothequeFault.setFaultString("user.not.active");

			throw new BibliothequeException("user.not.active", bibliothequeFault);

		}

		// generation du token
		String token = generateToken();
		// assignation au mail
		mail.setToken(token);
		mail.setTryToken(0);
		// creation d'une date d'expiration
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, expirationToken);
		mail.setExpiryToken(cal.getTime());

		String body = MessageFormat.format(bodyRecovery, mail.getToken());

		String[] tableau_email = { mail.getEmail() };

		sendMail.sendFromGMail(emailUsers, encrypt.getDecrypt(emailPassword), tableau_email, objectRecovery, body);
		logger.info("Send token to the email " + mail.getEmail());
		mailRepository.save(mail);
		logger.info("Update mail " + mail.getId());
	}

	@Override
	public void validateToken(String token, String email) throws BibliothequeException {

		Mail mail = mailRepository.findByEmail(email);

		// si les jetons correspondes et si le nombre
		// d'essais
		// et plus petit que 3
		if (token.equals(mail.getToken()) && mail.getTryToken() < 3) {

			// on vérifie la date
			if (!new Date().before(mail.getExpiryToken())) {
				logger.error("Token for email " + mail.getId() + " expiry");
				BibliothequeFault bibliothequeFault = new BibliothequeFault();
				bibliothequeFault.setFaultCode("10");
				bibliothequeFault.setFaultString("mail.token.expiry");

				throw new BibliothequeException("mail.token.expiry", bibliothequeFault);
			}
			// sinon on incrémente le nombre d'essais
		} else {

			// si le nombre d'essais est supérieur ou égal à 2
			if (mail.getTryToken() >= 2) {
				logger.error("Number of tests for token exceeded for mail " + mail.getId());
				BibliothequeFault bibliothequeFault = new BibliothequeFault();
				bibliothequeFault.setFaultCode("11");
				bibliothequeFault.setFaultString("mail.token.try.out");

				throw new BibliothequeException("mail.token.try.out", bibliothequeFault);
			}

			mail.setTryToken(mail.getTryToken() + 1);

			mailRepository.save(mail);
			logger.info("Increment tryToken for Mail " + mail.getId() + " and update");

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("12");
			bibliothequeFault.setFaultString("mail.token.not.correct");

			throw new BibliothequeException("mail.token.not.correct", bibliothequeFault);
		}
	}

	/**
	 * génération d'un token
	 * 
	 * @return token
	 */
	public String generateToken() {

		SecureRandom random = new SecureRandom();
		int longToken = Math.abs(random.nextInt());
		String randomString = Integer.toString(longToken, 16);
		logger.info("Generate token for password recovery");
		return randomString;
	}

}
