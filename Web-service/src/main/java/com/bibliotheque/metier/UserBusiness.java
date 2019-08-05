package com.bibliotheque.metier;

import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;

/**
 * interface métier utilisateur
 * 
 * @author pichat morgan
 *
 */
public interface UserBusiness {

	/**
	 * Validation d'un utilisateur
	 * 
	 * @param user
	 * @throws BibliothequeException --> pseudo vide, incorrect ou déjà utiliser
	 */
	public void validateUser(User user) throws BibliothequeException;

	/**
	 * validation du mot de passe
	 * 
	 * @param user
	 * @throws BibliothequeException --> mot de passe vide, mot de passe de
	 *                               confirmation vide, mot de passe non valide, la
	 *                               correspondance avec la confirmation est
	 *                               incorrect
	 */
	public void validatePassWord(User user) throws BibliothequeException;

	/**
	 * mise à jour d'un utilisateur
	 * 
	 * @param user
	 * @return Object utilisateur
	 * @throws BibliothequeException --> pseudo vide, incorrect ou déjà utiliser,
	 *                               mot de passe vide, mot de passe de confirmation
	 *                               vide, mot de passe non valide, la
	 *                               correspondance avec la confirmation est
	 *                               incorrect, ancien mot de passe non renseigné ou
	 *                               incorrect
	 */
	public User saveUser(User user) throws BibliothequeException;

	/**
	 * création d'un utilisateur
	 * 
	 * @param user
	 * @param mail
	 * @return Object utilisateur
	 * @throws BibliothequeException --> pseudo vide, incorrect ou déjà utiliser,
	 *                               mot de passe vide, mot de passe de confirmation
	 *                               vide, mot de passe non valide, la
	 *                               correspondance avec la confirmation est
	 *                               incorrect, ancien mot de passe non renseigné ou
	 *                               incorrect
	 */
	public User createUser(User user, Mail mail) throws BibliothequeException;

	/**
	 * Désactive le compte Utilisateur, ne le permettant plus de se connecter ou de
	 * démarrer le processus de récupération
	 * 
	 * @param id
	 */
	public void disableUser(Long id);

	/**
	 * Authentification d'un utilisateur
	 * 
	 * @param pseudo
	 * @param passWord
	 * @return object utilisateur
	 * @throws BibliothequeException --> pseudo incorrect, compte désactivé, mot de
	 *                               passe incorrect, nombre d'essais dépassé,
	 *                               Essais de connection avant expiration
	 */
	public User doConnection(String pseudo, String passWord) throws BibliothequeException;

	/**
	 * Récupère un utilisateur suivant son ID
	 * 
	 * @param id
	 * @return object utilisateur
	 * @throws BibliothequeException 
	 */
	public User getUser(Long id) throws BibliothequeException;

	/**
	 * modification du mot de passe par récupération
	 * 
	 * @param email
	 * @param password
	 * @param passwordConfirm
	 * @throws BibliothequeException --> mot de passe vide, mot de passe de confirmation
	 *                               vide, mot de passe non valide, la
	 *                               correspondance avec la confirmation est
	 *                               incorrect
	 */
	public void editPasswordByRecovery(String email, String password, String passwordConfirm)
			throws BibliothequeException;;
}
