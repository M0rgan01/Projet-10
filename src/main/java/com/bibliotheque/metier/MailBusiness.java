package com.bibliotheque.metier;

import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;

/**
 * interface métier mail
 * 
 * @author PICHAT morgan
 *
 */
public interface MailBusiness {

	/**
	 * validation d'une adresse mail
	 * 
	 * @param mail --> mail à vérifier
	 * @throws BibliothequeException --> attribut email vide ou non conforme ou déjà utiliser
	 */
	public void validateMail(Mail mail) throws BibliothequeException;
	
	/**
	 * mise à jour d'un mail
	 * 
	 * @param mail
	 * @param user_id --> id de l'utilisateur
	 * @throws BibliothequeException --> attribut email vide ou non conforme ou déjà utiliser
	 */
	public void saveMail(Mail mail, Long user_id) throws BibliothequeException;
	
	/**
	 * création d'un mail
	 * 
	 * @param mail
	 * @param user
	 * @throws BibliothequeException --> attribut email vide ou non conforme ou déjà utiliser
	 */
	public void createMail(Mail mail, User user) throws BibliothequeException;	
	
	/**
	 * récupération d'un mail par rapport à l'utilisateur 
	 * 
	 * @param id de l'utilisateur
	 * @return object Mail
	 */
	public Mail getMailByUserID(Long id);
	
	/**
	 * récupération d'un mail par rapport à son attribut email
	 * 
	 * @param email
	 * @return object Mail
	 */
	public Mail getMail(String email);
	
	/**
	 * envoie par email d'un token pour la récupération de mot de passe
	 * 
	 * @param email
	 * @throws BibliothequeException --> email incorrect, compte désactivé
	 */
	public void sendToken(String email) throws BibliothequeException;
	

	/**
	 * Validation du token pour la récupération de mot de passe
	 * 
	 * @param token
	 * @param email
	 * @throws BibliothequeException --> Validité du token dépassé, nombre d'éssais dépassé, token incorrect
	 */
	public void validateToken(String token, String email) throws BibliothequeException;
}
