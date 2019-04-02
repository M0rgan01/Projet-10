package com.bibliotheque.metier;

import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Utilisateur;
import com.bibliotheque.exception.BibliothequeException;

public interface MailMetier {

	public void validateMail(Mail mail) throws BibliothequeException;
	public void saveMail(Mail mail, Long utilisateur_id) throws BibliothequeException;
	public void createMail(Mail mail, Utilisateur utilisateur) throws BibliothequeException;
	public void deleteMail(Long id);
	public Mail getMailByUtilisateurID(Long id);
	public Mail getMail(String email);
}
