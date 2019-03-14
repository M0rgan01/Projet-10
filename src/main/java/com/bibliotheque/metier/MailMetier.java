package com.bibliotheque.metier;

import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Utilisateur;
import com.bibliotheque.exception.BibliothequeException;

public interface MailMetier {

	public void saveMail(Mail mail);
	public void createMail(Mail mail, Utilisateur utilisateur) throws BibliothequeException;
	public void deleteMail(Long id);
	public Mail getMail(Long id);
	public Mail getMail(String email);
}
