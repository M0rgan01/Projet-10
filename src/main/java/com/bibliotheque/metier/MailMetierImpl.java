package com.bibliotheque.metier;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.MailRepository;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Utilisateur;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;
import com.bibliotheque.utilities.Encrypt;
import com.bibliotheque.utilities.SendMail;


@Service
@PropertySource("classpath:bibliotheque.properties")
public class MailMetierImpl implements MailMetier{

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
	@Value("${mail.sujet}")
	private String emailSubject;
	@Value("${mail.expirationToken}")
	private int expirationToken;
	
	@Override
	public void saveMail(Mail mail, Long utilisateur_id) throws BibliothequeException {	
		Mail mail2 = getMailByUtilisateurID(utilisateur_id);
		validateMail(mail);
		mail2.setEmail(mail.getEmail());
		mailRepository.save(mail2);		
	}

	@Override
	public Mail getMailByUtilisateurID(Long id) {				
		return mailRepository.findByUtilisateurID(id);
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

	@Override
	public void deleteMailByUtilisateurID(Long utilisateur_id) {
		Mail mail = getMailByUtilisateurID(utilisateur_id);
		mailRepository.delete(mail);
	}

	@Override
	public void sendToken(String email) throws BibliothequeException {
		
		Mail mail = mailRepository.findByEmail(email);
		
		if (mail == null) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("50");
			bibliothequeFault.setFaultString("Aucune addresse corresponde");
			
			throw new BibliothequeException("Email non correct", bibliothequeFault);
		}
		
		//generation du token
		String token = generateToken();
		//assignation au mail
		mail.setToken(token);
		mail.setEssaisToken(0);
		//creation d'une date d'expiration
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, expirationToken);	
		mail.setExpirationToken(cal.getTime());
				
		System.out.println(token);
		
//		String body = " Voiçi le code pour réinitialisé le mot de passe de votre compte : " + token;
//		String[] tableau_email = { mail.getEmail() };
//		
//		sendMail.sendFromGMail(emailUsers, encrypt.getDecrypt(emailPassword), tableau_email, emailSubject, body);
		
		mailRepository.save(mail);	
	}

	
	@Override
	public void validateToken(String token, String email) throws BibliothequeException {
		
		Mail mail = mailRepository.findByEmail(email);
		
		// si les jetons correspondes et si le nombre
				// d'essais
				// et plus petit que 3
				if (token.equals(mail.getToken()) && mail.getEssaisToken() < 3) {
									
					// on vérifie la date
					if (!new Date().before(mail.getExpirationToken())) {
															
						BibliothequeFault bibliothequeFault = new BibliothequeFault();
						bibliothequeFault.setFaultCode("61");
						bibliothequeFault.setFaultString("La durée de validité du jeton est écoulé");
						
						throw new BibliothequeException("Token time not valide", bibliothequeFault);
					}
					// sinon on incrémente le nombre d'essais
				} else {
							
					if (mail.getEssaisToken() >= 2) {
						BibliothequeFault bibliothequeFault = new BibliothequeFault();
						bibliothequeFault.setFaultCode("62");
						bibliothequeFault.setFaultString("Nombre d'essais du token dépassé");
						
						throw new BibliothequeException("Essais token dépassé", bibliothequeFault);
					}
					
					mail.setEssaisToken(mail.getEssaisToken() +1 );
					// si le nombre d'essais est supérieur à 2
					
					mailRepository.save(mail);
													
					BibliothequeFault bibliothequeFault = new BibliothequeFault();
					bibliothequeFault.setFaultCode("63");
					bibliothequeFault.setFaultString("Jeton incorrect");
					
					throw new BibliothequeException("Jeton incorrect", bibliothequeFault);
				}				
	}
	
	 
	public String generateToken() {
		
		SecureRandom random = new SecureRandom();
		int longToken = Math.abs(random.nextInt());
		String randomString = Integer.toString(longToken, 16);
		return randomString;
	}


	
	
}
