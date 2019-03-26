package com.bibliotheque.metier;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.MailRepository;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Utilisateur;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;

@Service
public class MailMetierImpl implements MailMetier{

	@Autowired
	private MailRepository mailRepository;
	
	@Override
	public void saveMail(Mail mail) {		
		mailRepository.save(mail);		
	}

	@Override
	public void deleteMail(Long id) {
		mailRepository.deleteById(id);
	}

	@Override
	public Mail getMail(Long id) {				
		return mailRepository.findById(id).orElse(null);
	}

	@Override
	public Mail getMail(String email) {		
		return mailRepository.findByEmail(email);
	}

	@Override
	public void createMail(Mail mail, Utilisateur utilisateur) throws BibliothequeException {
		
		validateMail(mail);
		
		mail.setUtilisateur(utilisateur);
		
		Mail mail2 = getMail(mail.getEmail());
		
		if (mail2 != null) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("2");
			bibliothequeFault.setFaultString("L'adresse e-mail demander est déjà utilisé");
			
			throw new BibliothequeException("Email utilisé", bibliothequeFault);
		}
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
	}

}
