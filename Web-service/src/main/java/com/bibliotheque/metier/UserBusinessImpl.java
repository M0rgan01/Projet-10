package com.bibliotheque.metier;

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
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.UserRepository;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Roles;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;
import com.bibliotheque.utilities.Jasypt;

@Service
@PropertySource("classpath:bibliotheque.properties")
public class UserBusinessImpl implements UserBusiness {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MailBusiness mailBusiness;
	@Autowired
	private Jasypt encrypt;
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	@Value("${connection.expired.inMillis}")
	private int minuteInMillisForConnection;

	private static final Logger logger = LoggerFactory.getLogger(UserBusinessImpl.class);
	
	@Override
	public User saveUser(User user) throws BibliothequeException {

		User user2 = userRepository.findById(user.getId()).orElse(null);

		// si l'utilisateur à changer son pseudo
		if (!user.getPseudo().equals(user2.getPseudo())) {
			// on vérifie
			validateUser(user);
			user2.setPseudo(user.getPseudo());
			logger.info("Update pseudo for user " + user.getId());
		}
		// si l'utilisateur à renseigner un mot de passe ou un mot de passe de
		// confirmation
		if (!encrypt.getDecrypt(user.getPassWord()).isEmpty()
				|| !encrypt.getDecrypt(user.getPassWordConfirm()).isEmpty()) {

			// on décrypte l'ancien mot de passe
			user.setOldPassWord(encrypt.getDecrypt(user.getOldPassWord()));

			if (user.getOldPassWord().isEmpty()) {
				logger.error("OldPassword blank for user " + user.getId());
				BibliothequeFault bibliothequeFault = new BibliothequeFault();
				bibliothequeFault.setFaultCode("20");
				bibliothequeFault.setFaultString("user.oldPassword.blank");

				throw new BibliothequeException("user.oldPassword.blank", bibliothequeFault);

				// on vérifie la correspondance
			} else if (!bCrypt.matches(user.getOldPassWord(), user2.getPassWord())) {
				logger.error("OldPassword not match for user " + user.getId());
				BibliothequeFault bibliothequeFault = new BibliothequeFault();
				bibliothequeFault.setFaultCode("21");
				bibliothequeFault.setFaultString("user.oldPassword.not.correct");

				throw new BibliothequeException("user.oldPassword.not.correct", bibliothequeFault);
			}
			// validation des mots de passe
			validatePassWord(user);
			user2.setPassWord(bCrypt.encode(user.getPassWord()));
			logger.info("Update password for user " + user.getId());
		}

		return userRepository.save(user2);
	}

	@Override
	public void editPasswordByRecovery(String email, String password, String passwordConfirm)
			throws BibliothequeException {
			
		// récupération du mail
		Mail mail = mailBusiness.getMail(email);
		
		User user = mail.getUser();

		// on assigne les mots de passe
		user.setPassWord(password);
		user.setPassWordConfirm(passwordConfirm);

		// on vérifie
		validatePassWord(user);
		user.setPassWord(bCrypt.encode(user.getPassWord()));
		
		userRepository.save(user);		
		logger.info("Update password by recovery for user " + user.getId());
	}

	@Override
	public void disableUser(Long id) {
		User user = userRepository.findById(id).orElse(null);
		user.setActive(false);
		userRepository.save(user);
		logger.info("Disable account for user " + user.getId());
	}

	@Override
	public User doConnection(String pseudo, String passWord) throws BibliothequeException {

		User user = userRepository.findByPseudo(pseudo);
		passWord = encrypt.getDecrypt(passWord);

		if (user == null) {

			logger.error("User pseudo " + pseudo + " not found");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("22");
			bibliothequeFault.setFaultString("user.pseudo.not.correct");

			throw new BibliothequeException("user.pseudo.not.correct", bibliothequeFault);

		} else if (!user.isActive()) {
			
			logger.error("User account " + user.getId() + " disable");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("23");
			bibliothequeFault.setFaultString("user.not.active");

			throw new BibliothequeException("user.not.active", bibliothequeFault);

		} else {

			if (user.getExpiryConnection() != null) {

				if (user.getExpiryConnection().after(new Date())) {
					
					logger.info("User " + user.getId() + " try connection before the end of the expiry date");
					BibliothequeFault bibliothequeFault = new BibliothequeFault();
					bibliothequeFault.setFaultCode("24");
					bibliothequeFault.setFaultString("user.ExpiryConnection.after.date");
					throw new BibliothequeException("user.ExpiryConnection.after.date", bibliothequeFault);
				} else {
					user.setTryConnection(0);
					user.setExpiryConnection(null);
					userRepository.save(user);
					logger.info("End of the expiry date for user " + user.getId());
				}
			}

			if (bCrypt.matches(passWord, user.getPassWord())) {

				if (user.getTryConnection() > 0) {
					user.setTryConnection(0);
					user = userRepository.save(user);
					logger.info("Connection success for user " + user.getId());
				}

			} else {

				// on incrémente le nombre d'essais
				int a = user.getTryConnection();
				a++;
				user.setTryConnection(a);

				// si le nombre d'essais est à 3
				if (a == 3) {

					// on fixe un délais d'interdiction de connection
					Calendar date = Calendar.getInstance();
					long t = date.getTimeInMillis();
					Date afterAddingMins = new Date(t + (1 * minuteInMillisForConnection));
					user.setExpiryConnection(afterAddingMins);
					userRepository.save(user);
					
					logger.info("create date of expiry for connection for user " + user.getId());
					
					BibliothequeFault bibliothequeFault = new BibliothequeFault();
					bibliothequeFault.setFaultCode("25");
					bibliothequeFault.setFaultString("user.tryConnection.out");
					throw new BibliothequeException("user.tryConnection.out", bibliothequeFault);
				}

				userRepository.save(user);

				logger.info("Password not match for user " + user.getId());
				BibliothequeFault bibliothequeFault = new BibliothequeFault();
				bibliothequeFault.setFaultCode("26");
				bibliothequeFault.setFaultString("user.password.not.correct");
				throw new BibliothequeException("user.password.not.correct", bibliothequeFault);
			}
		}
		return user;
	}

	@Override
	public User createUser(User user, Mail mail) throws BibliothequeException {

		validateUser(user);
		validatePassWord(user);

		user.getRoles().add(new Roles("ROLE_USER"));
		//user.getRoles().add(new Roles("ROLE_ADMIN"));
		user.setActive(true);
		user.setPassWord(bCrypt.encode(user.getPassWord()));

		mailBusiness.createMail(mail, user);
		
		user = userRepository.save(user);
		logger.info("Create user " + user.getId());
		
		return user;
	}

	@Override
	public User getUser(Long id) throws BibliothequeException {
		
		User user = userRepository.findById(id).orElse(null);
		if (user == null) {
			logger.error("id user "+ id + " not correct");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("1");
			bibliothequeFault.setFaultString("user.id.not.correct");
			throw new BibliothequeException("user.id.not.correct", bibliothequeFault);
		}
		
		logger.info("Success get user " + user.getId());
	
		
		return user;
	}

	@Override
	public void validateUser(User user) throws BibliothequeException {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<User>> violations = validator.validate(user);

		for (ConstraintViolation<User> violation : violations) {

			logger.error("user " + violation.getPropertyPath() + " incorrect : " + violation.getMessage());
			
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultString(violation.getMessage());

			throw new BibliothequeException(violation.getMessage(), bibliothequeFault);
		}

		User user2 = userRepository.findByPseudo(user.getPseudo());

		if (user2 != null) {
			
			logger.error("user pseudo " + user2.getPseudo() + "already exist");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("27");
			bibliothequeFault.setFaultString("user.pseudo.already.exist");

			throw new BibliothequeException("user.pseudo.already.exist", bibliothequeFault);
		}
	}

	@Override
	public void validatePassWord(User user) throws BibliothequeException {
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";

		user.setPassWord(encrypt.getDecrypt(user.getPassWord()));
		user.setPassWordConfirm(encrypt.getDecrypt(user.getPassWordConfirm()));

		if (user.getPassWord().isEmpty()) {
			logger.error("user Password empty");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("28");
			bibliothequeFault.setFaultString("user.password.blank");

			throw new BibliothequeException("user.password.blank", bibliothequeFault);

		} else if (user.getPassWordConfirm().isEmpty()) {
			logger.error("user PasswordConfirm empty");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("29");
			bibliothequeFault.setFaultString("user.passwordConfirm.blank");

			throw new BibliothequeException("user.passwordConfirm.blank", bibliothequeFault);

		} else if (!user.getPassWord().matches(regex)) {
			logger.error("user Password not match regex");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("30");
			bibliothequeFault.setFaultString("user.password.not.true");

			throw new BibliothequeException("user.password.not.true", bibliothequeFault);

		} else if (!user.getPassWord().equals(user.getPassWordConfirm())) {
			logger.error("user Password not passwordConfirm");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("31");
			bibliothequeFault.setFaultString("user.password.not.match.passwordConfirm");
			throw new BibliothequeException("user.password.not.match.passwordConfirm", bibliothequeFault);

		}
	}

}
