package com.bibliotheque.metier;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.LoanRepository;
import com.bibliotheque.dao.MailRepository;
import com.bibliotheque.entities.Loan;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;
import com.bibliotheque.utilities.Encrypt;
import com.bibliotheque.utilities.SendMail;


@Service
@PropertySource("classpath:bibliotheque.properties")
public class MailBusinessImpl implements MailBusiness{

	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	private MailRepository mailRepository;
	@Autowired
	private Encrypt encrypt;
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
	
	@Override
	public void saveMail(Mail mail, Long user_id) throws BibliothequeException {	
		Mail mail2 = getMailByUserID(user_id);
		
		//si le nouveau email n'est pas égal à l'ancien
		if(!mail2.getEmail().equals(mail.getEmail())) {
			//validation de l'email
			validateMail(mail);
			//mise à jour
			mail2.setEmail(mail.getEmail());	
			mailRepository.save(mail2);	
		}						
	}

	@Override
	public Mail getMailByUserID(Long id) {				
		return mailRepository.findByUserID(id);
	}

	@Override
	public Mail getMail(String email) {		
		return mailRepository.findByEmail(email);
	}

	@Override
	public void createMail(Mail mail, User user) throws BibliothequeException {
		//validation
		validateMail(mail);	
		//attribution de l'utilisateur
		mail.setUser(user);
		//création
		mailRepository.save(mail);	
	}

	@Override
	public void validateMail(Mail mail) throws BibliothequeException {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<Mail>> violations = validator.validate(mail);
		
		for (ConstraintViolation<Mail> violation : violations) {
		   
		    BibliothequeFault bibliothequeFault = new BibliothequeFault();			
			bibliothequeFault.setFaultString(violation.getMessage());
			
			throw new BibliothequeException(violation.getMessage(), bibliothequeFault);
		}
		
		Mail mail2 = getMail(mail.getEmail());
		
		if (mail2 != null) {
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
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("8");
			bibliothequeFault.setFaultString("mail.email.not.correct");
			
			throw new BibliothequeException("mail.email.not.correct", bibliothequeFault);
			
		}else if(!mail.getUser().isActive()) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("9");
			bibliothequeFault.setFaultString("user.not.active");

			throw new BibliothequeException("user.not.active", bibliothequeFault);
			
		}
		
		//generation du token
		String token = generateToken();
		//assignation au mail
		mail.setToken(token);
		mail.setTryToken(0);
		//creation d'une date d'expiration
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, expirationToken);		
		mail.setExpiryToken(cal.getTime());		
			
		String body = MessageFormat.format( bodyRecovery, mail.getToken());
		
		String[] tableau_email = { mail.getEmail() };
		
		//sendMail.sendFromGMail(emailUsers, encrypt.getDecrypt(emailPassword), tableau_email, objectRecovery, body);
		
		mailRepository.save(mail);	
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
															
						BibliothequeFault bibliothequeFault = new BibliothequeFault();
						bibliothequeFault.setFaultCode("10");
						bibliothequeFault.setFaultString("mail.token.expiry");
						
						throw new BibliothequeException("mail.token.expiry", bibliothequeFault);
					}
					// sinon on incrémente le nombre d'essais
				} else {

					// si le nombre d'essais est supérieur ou égal à 2	
					if (mail.getTryToken() >= 2) {
						BibliothequeFault bibliothequeFault = new BibliothequeFault();
						bibliothequeFault.setFaultCode("11");
						bibliothequeFault.setFaultString("mail.token.try.out");
						
						throw new BibliothequeException("mail.token.try.out", bibliothequeFault);
					}
					
					mail.setTryToken(mail.getTryToken() +1 );
									
					mailRepository.save(mail);
													
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
		return randomString;
	}


}
