package com.bibliotheque.metier;

import com.bibliotheque.entities.Mail;

public interface MailMetier {

	public void saveMail(Mail mail);
	public void deleteMail(Long id);
	public Mail getMail(Long id);
}
