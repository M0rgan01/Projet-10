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

@Service
public class UtilisateurMetierImpl implements UtilisateurMetier {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private MailMetier mailMetier;

	@Override
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public void deleteUtilisateur(Long id) {
		utilisateurRepository.deleteById(id);
	}

	@Override
	public Utilisateur doConnection(String pseudo, String passWord) throws BibliothequeException {

		Utilisateur utilisateur = utilisateurRepository.findByPseudo(pseudo);

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
					System.out.println("coucou");
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
	public void createUtilisateur(Utilisateur utilisateur, Mail mail) throws BibliothequeException {
		  
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<Utilisateur>> violations = validator.validate(utilisateur);
		
		for (ConstraintViolation<Utilisateur> violation : violations) {
		   
		    BibliothequeFault bibliothequeFault = new BibliothequeFault();			
			bibliothequeFault.setFaultString(violation.getMessage());
			
			throw new BibliothequeException(violation.getMessage(), bibliothequeFault);
		}
			
		checkPseudoExist(utilisateur.getPseudo());

		utilisateur.setPassWord(new BCryptPasswordEncoder().encode(utilisateur.getPassWord()));
		utilisateur.getRoles().add(new Roles("ROLE_USER"));
		utilisateur.setActive(true);
		
		mailMetier.createMail(mail, utilisateur);
		utilisateurRepository.save(utilisateur);
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

}
