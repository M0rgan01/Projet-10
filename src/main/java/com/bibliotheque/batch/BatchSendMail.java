package com.bibliotheque.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bibliotheque.Projet7WebServiceApplication;
import com.bibliotheque.metier.MailBusiness;

/**
 * Batch de rappel pour les retards de retour de livre
 * 
 * @author PICHAT morgan
 *
 */
@Component
public class BatchSendMail {

	@Autowired
	private MailBusiness mailBusiness;

	/**
	 * méthode de rappel des retard par email, réalisé tous les 1er de chaque mois a
	 * minuit
	 * 
	 */
	@Scheduled(cron = "0 0 0 1 * *")
	public void reportCurrentTime() {
		mailBusiness.sendMailForLateLoan();
		Projet7WebServiceApplication.logger.info("Batch de rappel de retard par email réalisé avec succès");
	}
}
