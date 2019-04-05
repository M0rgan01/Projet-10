package com.bibliotheque.metier;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.UserRepository;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Roles;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;
import com.bibliotheque.utilities.Encrypt;

@Service
public class UserBusinessImpl implements UserBusiness {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MailBusiness mailBusiness;
	@Autowired
	private Encrypt encrypt;

	@Override
	public User saveUser(User user) throws BibliothequeException {

		User user2 = userRepository.findById(user.getId()).orElse(null);

		validateUser(user);

		if (!user.getPseudo().isEmpty() && !user.getPseudo().equals(user2.getPseudo())) {
			checkPseudoExist(user.getPseudo());
			user2.setPseudo(user.getPseudo());
		}

		if (!user.getPassWord().isEmpty() || !user.getPassWordConfirm().isEmpty()) {

			user.setOldPassWord(encrypt.getDecrypt(user.getOldPassWord()));

			if (user.getOldPassWord().isEmpty()) {

				BibliothequeFault bibliothequeFault = new BibliothequeFault();
				bibliothequeFault.setFaultCode("24");
				bibliothequeFault.setFaultString("L'ancien mot de passe n'est pas renseigné");

				throw new BibliothequeException("oldMPD blank", bibliothequeFault);

			} else if (!new BCryptPasswordEncoder().matches(user.getOldPassWord(), user2.getPassWord())) {

				BibliothequeFault bibliothequeFault = new BibliothequeFault();
				bibliothequeFault.setFaultCode("25");
				bibliothequeFault.setFaultString("L'ancien mot de passe n'est pas correct");

				throw new BibliothequeException("oldMPD invalide", bibliothequeFault);
			}

			validatePassWord(user);
			user2.setPassWord(new BCryptPasswordEncoder().encode(user.getPassWord()));

		}

		return userRepository.save(user2);
	}

	@Override
	public void editPasswordByRecovery(String email, String password, String passwordConfirm) throws BibliothequeException {
		
		Mail mail = mailBusiness.getMail(email);
		
		User user = mail.getUser();
		user.setPassWord(password);
		user.setPassWordConfirm(passwordConfirm);
		validatePassWord(user);
		user.setPassWord(new BCryptPasswordEncoder().encode(user.getPassWord()));
		userRepository.save(user);
	}
	
	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User doConnection(String pseudo, String passWord) throws BibliothequeException {

		User user = userRepository.findByPseudo(pseudo);
		passWord = encrypt.getDecrypt(passWord);

		if (user == null) {

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("3");
			bibliothequeFault.setFaultString("Le pseudo n'à aucune correspondance");

			throw new BibliothequeException("Pseudo non correspondant", bibliothequeFault);

		} else {

			if (user.getExpiryConnection() != null) {

				if (user.getExpiryConnection().after(new Date())) {
					BibliothequeFault bibliothequeFault = new BibliothequeFault();
					bibliothequeFault.setFaultCode("4");
					bibliothequeFault.setFaultString("Essais de connection avant expiration de la date des 3 essais");
					throw new BibliothequeException("Essais date expiration", bibliothequeFault);
				} else {
					user.setTryConnection(0);
					user.setExpiryConnection(null);
					userRepository.save(user);
				}
			}

			if (new BCryptPasswordEncoder().matches(passWord, user.getPassWord())) {

				if (user.getTryConnection() > 0) {
					user.setTryConnection(0);
					userRepository.save(user);
				}

			} else {

				int a = user.getTryConnection();
				a++;
				user.setTryConnection(a);

				if (a == 3) {
					Calendar date = Calendar.getInstance();
					long t = date.getTimeInMillis();
					Date afterAddingTenMins = new Date(t + (1 * 60000));
					user.setExpiryConnection(afterAddingTenMins);
					userRepository.save(user);

					BibliothequeFault bibliothequeFault = new BibliothequeFault();
					bibliothequeFault.setFaultCode("5");
					bibliothequeFault.setFaultString("Nombre d'essais dépassé, veuillez réessayer plus tard");
					throw new BibliothequeException("3 essais dépassé", bibliothequeFault);
				}

				userRepository.save(user);

				BibliothequeFault bibliothequeFault = new BibliothequeFault();
				bibliothequeFault.setFaultCode("6");
				bibliothequeFault.setFaultString("Mot de passe incorrect");
				throw new BibliothequeException("PassWord incorrect", bibliothequeFault);
			}
		}
		return user;
	}

	@Override
	public User createUser(User user, Mail mail) throws BibliothequeException {

		validateUser(user);
		validatePassWord(user);
		checkPseudoExist(user.getPseudo());

		user.getRoles().add(new Roles("ROLE_USER"));
		user.getRoles().add(new Roles("ROLE_ADMIN"));
		user.setActive(true);
		user.setPassWord(new BCryptPasswordEncoder().encode(user.getPassWord()));

		mailBusiness.createMail(mail, user);
		return userRepository.save(user);
	}

	@Override
	public void checkPseudoExist(String pseudo) throws BibliothequeException {
		User user = userRepository.findByPseudo(pseudo);

		if (user != null) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("1");
			bibliothequeFault.setFaultString("Le pseudo demander est déjà utilisé");

			throw new BibliothequeException("Pseudo utilisé", bibliothequeFault);
		}
	}

	@Override
	public User getUser(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public void validateUser(User user) throws BibliothequeException {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<User>> violations = validator.validate(user);

		for (ConstraintViolation<User> violation : violations) {

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultString(violation.getMessage());

			throw new BibliothequeException(violation.getMessage(), bibliothequeFault);
		}

	}

	@Override
	public void validatePassWord(User user) throws BibliothequeException {
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";

		user.setPassWord(encrypt.getDecrypt(user.getPassWord()));
		user.setPassWordConfirm(encrypt.getDecrypt(user.getPassWordConfirm()));

		if (user.getPassWord().isEmpty()) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("20");
			bibliothequeFault.setFaultString("Le mot de passe est vide");

			throw new BibliothequeException("MDP vide", bibliothequeFault);

		} else if (user.getPassWordConfirm().isEmpty()) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("21");
			bibliothequeFault.setFaultString("Le mot de passe de confirmation est vide");

			throw new BibliothequeException("MDPconfirm vide", bibliothequeFault);

		} else if (!user.getPassWord().matches(regex)) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("22");
			bibliothequeFault.setFaultString(
					"Le mot de passe doit contenir au moin une minuscule, une majuscule, et un chiffre");

			throw new BibliothequeException("MDP non valide", bibliothequeFault);

		} else if (!user.getPassWord().equals(user.getPassWordConfirm())) {

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("23");
			bibliothequeFault.setFaultString("Le mot de passe de confirmation ne correspond pas au mot de passe.");
			throw new BibliothequeException("Confirmation MDP incorrect", bibliothequeFault);

		}
	}



}
