package com.bibliotheque.metier;

import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;

public interface MailBusiness {

	public void validateMail(Mail mail) throws BibliothequeException;
	public void saveMail(Mail mail, Long user_id) throws BibliothequeException;
	public void createMail(Mail mail, User user) throws BibliothequeException;
	public void deleteMailByUserID(Long user_id);
	public Mail getMailByUserID(Long id);
	public Mail getMail(String email);
	public void sendToken(String email) throws BibliothequeException;
	public void validateToken(String token, String email) throws BibliothequeException;
}
