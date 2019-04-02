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
import com.bibliotheque.dao.UtilisateurRepository;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Roles;
import com.bibliotheque.entities.Utilisateur;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;
import com.bibliotheque.utilities.Encrypt;

@Service
public class UtilisateurMetierImpl implements UtilisateurMetier {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private MailMetier mailMetier;
	@Autowired
	private Encrypt encrypt;

	@Override
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) throws BibliothequeException {

		Utilisateur utilisateur2 = utilisateurRepository.findById(utilisateur.getId()).orElse(null);

		validateUtilisateur(utilisateur);

		if (!utilisateur.getPseudo().isEmpty() && !utilisateur.getPseudo().equals(utilisateur2.getPseudo())) {
			checkPseudoExist(utilisateur.getPseudo());
			utilisateur2.setPseudo(utilisateur.getPseudo());
		}

		if (!utilisateur.getPassWord().isEmpty() || !utilisateur.getPassWordConfirm().isEmpty()) {

			utilisateur.setOldPassWord(encrypt.getDecrypt(utilisateur.getOldPassWord()));

			if (utilisateur.getOldPassWord().isEmpty()) {

				BibliothequeFault bibliothequeFault = new BibliothequeFault();
				bibliothequeFault.setFaultCode("24");
				bibliothequeFault.setFaultString("L'ancien mot de passe n'est pas renseigné");

				throw new BibliothequeException("oldMPD blank", bibliothequeFault);

			} else if (!new BCryptPasswordEncoder().matches(utilisateur.getOldPassWord(), utilisateur2.getPassWord())) {

				BibliothequeFault bibliothequeFault = new BibliothequeFault();
				bibliothequeFault.setFaultCode("25");
				bibliothequeFault.setFaultString("L'ancien mot de passe n'est pas correct");

				throw new BibliothequeException("oldMPD invalide", bibliothequeFault);
			}

			validatePassWord(utilisateur);
			utilisateur2.setPassWord(new BCryptPasswordEncoder().encode(utilisateur.getPassWord()));

		}

		return utilisateurRepository.save(utilisateur2);
	}

	@Override
	public void deleteUtilisateur(Long id) {
		utilisateurRepository.deleteById(id);
	}

	@Override
	public Utilisateur doConnection(String pseudo, String passWord) throws BibliothequeException {

		Utilisateur utilisateur = utilisateurRepository.findByPseudo(pseudo);
		passWord = encrypt.getDecrypt(passWord);

		if (utilisateur == null) {

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("3");
			bibliothequeFault.setFaultString("Le pseudo n'à aucune correspondance");

			throw new BibliothequeException("Pseudo non correspondant", bibliothequeFault);

		} else {

			if (utilisateur.getExpirationConnection() != null) {

				if (utilisateur.getExpirationConnection().after(new Date())) {
					BibliothequeFault bibliothequeFault = new BibliothequeFault();
					bibliothequeFault.setFaultCode("4");
					bibliothequeFault.setFaultString("Essais de connection avant expiration de la date des 3 essais");
					throw new BibliothequeException("Essais date expiration", bibliothequeFault);
				} else {
					utilisateur.setEssaisConnection(0);
					utilisateur.setExpirationConnection(null);
					utilisateurRepository.save(utilisateur);
				}
			}

			if (new BCryptPasswordEncoder().matches(passWord, utilisateur.getPassWord())) {

				if (utilisateur.getEssaisConnection() > 0) {
					utilisateur.setEssaisConnection(0);
					utilisateurRepository.save(utilisateur);
				}

			} else {

				int a = utilisateur.getEssaisConnection();
				a++;
				utilisateur.setEssaisConnection(a);

				if (a == 3) {
					Calendar date = Calendar.getInstance();
					long t = date.getTimeInMillis();
					Date afterAddingTenMins = new Date(t + (1 * 60000));
					utilisateur.setExpirationConnection(afterAddingTenMins);
					utilisateurRepository.save(utilisateur);

					BibliothequeFault bibliothequeFault = new BibliothequeFault();
					bibliothequeFault.setFaultCode("5");
					bibliothequeFault.setFaultString("Nombre d'essais dépassé, veuillez réessayer plus tard");
					throw new BibliothequeException("3 essais dépassé", bibliothequeFault);
				}

				utilisateurRepository.save(utilisateur);

				BibliothequeFault bibliothequeFault = new BibliothequeFault();
				bibliothequeFault.setFaultCode("6");
				bibliothequeFault.setFaultString("Mot de passe incorrect");
				throw new BibliothequeException("PassWord incorrect", bibliothequeFault);
			}
		}
		return utilisateur;
	}

	@Override
	public Utilisateur createUtilisateur(Utilisateur utilisateur, Mail mail) throws BibliothequeException {

		validateUtilisateur(utilisateur);
		validatePassWord(utilisateur);
		checkPseudoExist(utilisateur.getPseudo());

		utilisateur.getRoles().add(new Roles("ROLE_USER"));
		utilisateur.getRoles().add(new Roles("ROLE_ADMIN"));
		utilisateur.setActive(true);
		utilisateur.setPassWord(new BCryptPasswordEncoder().encode(utilisateur.getPassWord()));

		mailMetier.createMail(mail, utilisateur);
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public void checkPseudoExist(String pseudo) throws BibliothequeException {
		Utilisateur utilisateur = utilisateurRepository.findByPseudo(pseudo);

		if (utilisateur != null) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("1");
			bibliothequeFault.setFaultString("Le pseudo demander est déjà utilisé");

			throw new BibliothequeException("Pseudo utilisé", bibliothequeFault);
		}
	}

	@Override
	public Utilisateur getUtilisateur(Long id) {
		return utilisateurRepository.findById(id).orElse(null);
	}

	@Override
	public void validateUtilisateur(Utilisateur utilisateur) throws BibliothequeException {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Utilisateur>> violations = validator.validate(utilisateur);

		for (ConstraintViolation<Utilisateur> violation : violations) {

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultString(violation.getMessage());

			throw new BibliothequeException(violation.getMessage(), bibliothequeFault);
		}

	}

	@Override
	public void validatePassWord(Utilisateur utilisateur) throws BibliothequeException {
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";

		utilisateur.setPassWord(encrypt.getDecrypt(utilisateur.getPassWord()));
		utilisateur.setPassWordConfirm(encrypt.getDecrypt(utilisateur.getPassWordConfirm()));

		if (utilisateur.getPassWord().isEmpty()) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("20");
			bibliothequeFault.setFaultString("Le mot de passe est vide");

			throw new BibliothequeException("MDP vide", bibliothequeFault);

		} else if (utilisateur.getPassWordConfirm().isEmpty()) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("21");
			bibliothequeFault.setFaultString("Le mot de passe de confirmation est vide");

			throw new BibliothequeException("MDPconfirm vide", bibliothequeFault);

		} else if (!utilisateur.getPassWord().matches(regex)) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("22");
			bibliothequeFault.setFaultString(
					"Le mot de passe doit contenir au moin une minuscule, une majuscule, et un chiffre");

			throw new BibliothequeException("MDP non valide", bibliothequeFault);

		} else if (!utilisateur.getPassWord().equals(utilisateur.getPassWordConfirm())) {

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("23");
			bibliothequeFault.setFaultString("Le mot de passe de confirmation ne correspond pas au mot de passe.");
			throw new BibliothequeException("Confirmation MDP incorrect", bibliothequeFault);

		}
	}

}
