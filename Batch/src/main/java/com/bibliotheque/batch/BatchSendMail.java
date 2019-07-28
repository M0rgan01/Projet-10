package com.bibliotheque.batch;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bibliotheque.service.BibliothequeServiceService;
import com.bibliotheque.service.BibliothequeWS;
import com.bibliotheque.service.Loan;
import com.bibliotheque.service.Mail;
import com.bibliotheque.utilities.Jasypt;
import com.bibliotheque.utilities.SendMail;

/**
 * Batch de rappel pour les retards de retour de livre
 * 
 * @author PICHAT morgan
 *
 */
@Component
public class BatchSendMail {

	private static final Logger logger = LoggerFactory.getLogger(BatchSendMail.class);
	
	@Autowired
	private Jasypt encrypt;
	@Autowired
	private SendMail sendMail;
	@Value("${mail.username}")
	private String emailUsers;
	@Value("${mail.password}")
	private String emailPassword;
	@Value("${mail.object.late}")
	private String objectLate;
	@Value("${mail.body.late}")
	private String bodyLate;
	
	/**
	 * méthode de rappel des retard par email, réalisé tous les 1er de chaque mois a
	 * minuit
	 * 
	 */
	@Scheduled(cron = "${cron.send.mail}")
	public void reportCurrentTime() {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();
		//on récupère la list des emprunt en retard
		List<Loan> list = ws.getListLoanLate();

		//pour chaque emprunt on envoie un email de rappel 
		for (Loan loan : list) {

			Mail mail = ws.getMail(loan.getUser().getId());

			String[] tableau_email = { mail.getEmail() };

			String object = MessageFormat.format(objectLate, loan.getBook().getTitle());

			String pattern = "dd/MM/yyyy";
			DateFormat df = new SimpleDateFormat(pattern);

			String body = MessageFormat.format(bodyLate, loan.getBook().getTitle(), df.format(loan.getEndLoan()));

			 sendMail.sendFromGMail(emailUsers, encrypt.getDecrypt(emailPassword),
			 tableau_email, object, body);
			 
			 logger.info("Envoie d'un email à l'utilisateur" + loan.getUser().getPseudo() + "pour le retard du livre" + loan.getBook().getId());
		}

		logger.info("Batch de rappel de retard par email realise avec succes");
	}
}
