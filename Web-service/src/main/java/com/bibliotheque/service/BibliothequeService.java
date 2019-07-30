package com.bibliotheque.service;

import java.text.ParseException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bibliotheque.entities.Book;
import com.bibliotheque.entities.Kind;
import com.bibliotheque.entities.Loan;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Reservation;
import com.bibliotheque.entities.Roles;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.metier.BookBusiness;
import com.bibliotheque.metier.KindBusiness;
import com.bibliotheque.metier.LoanBusiness;
import com.bibliotheque.metier.MailBusiness;
import com.bibliotheque.metier.Pagination;
import com.bibliotheque.metier.ReservationBusiness;
import com.bibliotheque.metier.RolesBusiness;
import com.bibliotheque.metier.UserBusiness;

/**
 * 
 * Web service de gestion d'une bibliotheque
 * 
 * @author pichat morgan
 *
 */
@Component
@WebService(name = "BibliothequeWS")
public class BibliothequeService {

	@Autowired
	private UserBusiness userBusiness;
	@Autowired
	private MailBusiness mailBusiness;
	@Autowired
	private BookBusiness bookBusiness;
	@Autowired
	private KindBusiness kindBusiness;
	@Autowired
	private LoanBusiness loanBusiness;
	@Autowired
	private RolesBusiness rolesBusiness;
	@Autowired
	private ReservationBusiness reservationBusiness;
	
//////////////////////// AUTHENTIFICATION - GESTION COMPTE UTILISATEUR ////////////////////////

	/**
	 * service de mise à jour d'un utilisateur
	 * 
	 * @param user
	 * @throws BibliothequeException --> pseudo vide, incorrect ou déjà utiliser,
	 *                               mot de passe vide, mot de passe de confirmation
	 *                               vide, mot de passe non valide, la
	 *                               correspondance avec la confirmation est
	 *                               incorrect, ancien mot de passe non renseigné ou
	 *                               incorrect
	 */
	@WebMethod
	public void saveUser(@WebParam(name = "user") User user) throws BibliothequeException {
		userBusiness.saveUser(user);
	}

	/**
	 * service de création d'un utilisateur
	 * 
	 * @param user
	 * @param mail
	 * @return Object user
	 * @throws BibliothequeException --> pseudo vide, incorrect ou déjà utiliser,
	 *                               mot de passe vide, mot de passe de confirmation
	 *                               vide, mot de passe non valide, la
	 *                               correspondance avec la confirmation est
	 *                               incorrect, ancien mot de passe non renseigné ou
	 *                               incorrect
	 */
	@WebMethod
	public User createUser(@WebParam(name = "user") User user, @WebParam(name = "mail") Mail mail)
			throws BibliothequeException {
		return userBusiness.createUser(user, mail);
	}

	/**
	 * Service de désactivation d'un compte utilisateur, ne le permettant plus de se
	 * connecter ou de démarrer le processus de récupération
	 * 
	 * @param id
	 */
	@WebMethod
	public void deleteUser(@WebParam(name = "id") Long id) {
		userBusiness.disableUser(id);
	}

	/**
	 * Service de récupèration d'un utilisateur suivant son ID
	 * 
	 * @param id
	 * @return object user
	 */
//	@WebMethod
//	public User getUser(@WebParam(name = "id") Long id) {
//		return userBusiness.getUser(id);
//	}

	/**
	 * Service d'authentification d'un utilisateur
	 * 
	 * @param pseudo
	 * @param passWord (non brut --> jasypt)
	 * @return object user
	 * @throws BibliothequeException --> pseudo incorrect, compte désactivé, mot de
	 *                               passe incorrect, nombre d'essais dépassé,
	 *                               Essais de connection avant expiration
	 */
	@WebMethod
	public User doConnection(@WebParam(name = "pseudo") String pseudo, @WebParam(name = "passWord") String passWord)
			throws BibliothequeException {
		return userBusiness.doConnection(pseudo, passWord);
	}

	/**
	 * Service de mise à jour d'un mail
	 * 
	 * @param mail
	 * @param user_id --> id de l'utilisateur
	 * @throws BibliothequeException --> attribut email vide ou non conforme ou déjà
	 *                               utiliser
	 */
	@WebMethod
	public void saveMail(@WebParam(name = "mail") Mail mail, @WebParam(name = "user_id") Long user_id)
			throws BibliothequeException {
		mailBusiness.saveMail(mail, user_id);
	}

	/**
	 * Service de récupération d'un mail par rapport à son attribut user_id
	 * 
	 * @param email
	 * @return object Mail
	 */
	@WebMethod
	public Mail getMail(@WebParam(name = "user_id") Long id) {
		return mailBusiness.getMailByUserID(id);
	}

	/**
	 * Service de récupèration des roles d'un utilisateur
	 * 
	 * @param pseudo --> pseudo de l'utilisateur
	 * @return liste de role
	 */
	@WebMethod
	public List<Roles> getListRoles(@WebParam(name = "pseudo") String pseudo) {
		return rolesBusiness.getListRoles(pseudo);
	}

	/**
	 * Service d'envoie par email d'un token pour la récupération de mot de passe
	 * 
	 * @param email
	 * @throws BibliothequeException --> email incorrect, compte désactivé
	 */
	@WebMethod
	public void sendToken(@WebParam(name = "email") String email) throws BibliothequeException {
		mailBusiness.sendToken(email);
	}

	/**
	 * Service de validation du token pour la récupération de mot de passe
	 * 
	 * @param token
	 * @param email
	 * @throws BibliothequeException --> Validité du token dépassé, nombre d'éssais
	 *                               dépassé, token incorrect
	 */
	@WebMethod
	public void validateToken(@WebParam(name = "email") String email, @WebParam(name = "token") String token)
			throws BibliothequeException {
		mailBusiness.validateToken(token, email);
	}

	/**
	 * Service de modification du mot de passe par récupération
	 * 
	 * @param email
	 * @param password        (non brut --> jasypt)
	 * @param passwordConfirm (non brut --> jasypt)
	 * @throws BibliothequeException --> mot de passe vide, mot de passe de
	 *                               confirmation vide, mot de passe non valide, la
	 *                               correspondance avec la confirmation est
	 *                               incorrect
	 */
	@WebMethod
	public void editPassWordByRecovery(@WebParam(name = "email") String email,
			@WebParam(name = "password") String passWord, @WebParam(name = "passwordConfirm") String passWordConfirm)
			throws BibliothequeException {
		userBusiness.editPasswordByRecovery(email, passWord, passWordConfirm);
	}

//////////////////////// GESTION OUVRAGE - RECHERCHE ////////////////////////

	/**
	 * Service de création d'un ouvrage
	 * 
	 * @param book --> ouvrage à créer
	 * 
	 * @throws BibliothequeException --> attribut title, author, description,
	 *                               copyTotals, kind non renseigné ou incorrect
	 */
	@WebMethod
	public void createBook(@WebParam(name = "book") Book book) throws BibliothequeException {
		bookBusiness.createBook(book);
	}

	/**
	 * Service de mise à jour d'un ouvrage
	 * 
	 * @param book --> ouvrage à mettre à jour
	 * @param kind --> genre lié au livre
	 * 
	 * @throws BibliothequeException --> attribut ID, title, author, description,
	 *                               copyTotals, kind non renseigné ou incorrect
	 */
	@WebMethod
	public void updateBook(@WebParam(name = "book") Book book) throws BibliothequeException {
		bookBusiness.saveBook(book);
	}

	/**
	 * Rend un livre non visible dans la récupération pour la recherche ou l'emprunt
	 * 
	 * @param id --> ID du livre
	 * @throws BibliothequeException --> attribut ID incorrect ou déjà non visible
	 */
	@WebMethod
	public void deleteBook(Long id) throws BibliothequeException {
		bookBusiness.deleteBook(id);
	}

	/**
	 * Service de récupération d'un livre
	 * 
	 * @param id --> ID du livre
	 * 
	 * @return Object book
	 * @throws BibliothequeException --> attribut ID incorrect
	 */
	@WebMethod
	public Book getBook(Long id) throws BibliothequeException {
		return bookBusiness.getBook(id);
	}

	/**
	 * service de récupération d'un object pagination
	 * 
	 * @param mc        --> mot clé
	 * @param kind      --> genre du livre
	 * @param available --> disponibilité du livre
	 * @param page      --> page à chercher
	 * @param size      --> taille de la page
	 * 
	 * @return Page d'ouvrage
	 */
	@WebMethod
	public Pagination<Book> listBook(@WebParam(name = "mot-cle") String mc, @WebParam(name = "kind") String kind,
			@WebParam(name = "available") boolean available, @WebParam(name = "page") int page,
			@WebParam(name = "size") int size) {
		return bookBusiness.listBook(mc, kind, available, page, size);
	}

	/**
	 * service de récupération d'une liste de genre
	 * 
	 * @return Liste de genre
	 */
	@WebMethod
	public List<Kind> getListKind() {
		return kindBusiness.getListKind();
	}


//////////////////////// GESTION EMPRUNT ////////////////////////

	/**
	 * Service de création d'un emprunt
	 * 
	 * @param book_id --> livre lié à l'emprunt
	 * @param user_id --> utilisateur lié à l'emprunt
	 * @throws BibliothequeException--> book_id incorrect, user_id incorrect,
	 *                                  ouvrage non disponible
	 */
	@WebMethod
	public void createLoan(@WebParam(name = "book_id") Long book_id, @WebParam(name = "user_id") Long user_id)
			throws BibliothequeException, ParseException {
		loanBusiness.createLoan(book_id, user_id);
	}

	/**
	 * Service de rendu d'un emprunt
	 * 
	 * @param id --> id de l'emprunt
	 */
	@WebMethod
	public void returnLoan(Long id) {
		loanBusiness.returnLoan(id);
	}

	/**
	 * Service de Récupération d'un emprunt
	 * 
	 * @param id --> id de l'emprunt
	 * @return emprunt
	 */
	@WebMethod
	public Loan getLoan(Long id) {
		return loanBusiness.getLoan(id);
	}

	/**
	 * Service de récupération des emprunts actuel sans retard d'un utilisateur
	 * 
	 * @param user_id --> id utilisateur
	 * @return liste d'emprunt
	 */
	@WebMethod
	public List<Loan> getListLoanByUserID(@WebParam(name = "user_id") Long user_id) {
		return loanBusiness.getListLoanByUserID(user_id);
	}

	/**
	 * Service de récupération des emprunts actuel en retard
	 * 
	 * @return liste d'emprunt
	 */
	@WebMethod
	public List<Loan> getListLoanLate() {
		return loanBusiness.getListLoanLate();
	}

	/**
	 * Service de récupération des emprunts actuel en retard d'un utilisateur
	 * 
	 * @param user_id --> id utilisateur
	 * @return liste d'emprunt
	 */
	@WebMethod
	public List<Loan> getListLoanLateByUserID(@WebParam(name = "user_id") Long user_id) {
		return loanBusiness.getListLoanLateByUserID(user_id);
	}

	/**
	 * Service d'extention de la date de fin d'un emprunt
	 * 
	 * @param loanID  --> id de l'emprunt
	 * @param user_id --> id utilisateur
	 * @throws BibliothequeException --> loanID incorrect, user_id incorrect,
	 *                               emprunt déjà en prolongation, retard même après
	 *                               prolongation
	 */
	@WebMethod
	public void extendLoan(@WebParam(name = "Loan_ID") Long Loan_ID, @WebParam(name = "user_id") Long user_ID)
			throws BibliothequeException {
		loanBusiness.extendLoan(Loan_ID, user_ID);
	}

	/**
	 * @return Nombre de jour pour l'extention d'un emprunt
	 */
	@WebMethod
	public int getDaysExtend() throws BibliothequeException {
		return loanBusiness.getDaysExtend();
	}

	/**
	 * @return Nombre de jour d'un emprunt
	 */
	@WebMethod
	public int getDaysLoan() throws BibliothequeException {
		return loanBusiness.getDaysLoan();
	}
	
	
	
////////////////////////GESTION RESERVATION ////////////////////////
	
	/**
	 * Service de création d'une reservation
	 * 
	 * @param user_id --> id utilisateur
	 * @throws BibliothequeException 
	 */
	@WebMethod
	public Reservation createReservation(@WebParam(name = "Book_ID") Long Book_ID, @WebParam(name = "user_id") Long user_ID) throws BibliothequeException {
		return reservationBusiness.createReservation(Book_ID, user_ID);
	}
	
	/**
	 * Service de supression d'une reservation
	 * 
	 * @param user_id --> id utilisateur
	 * @throws BibliothequeException 
	 */
	@WebMethod
	public void deleteReservation(@WebParam(name = "Book_ID") Long Book_ID, @WebParam(name = "user_id") Long user_ID) throws BibliothequeException {
	   reservationBusiness.deleteReservation(Book_ID, user_ID);
	}
	
	
	/**
	 * Service de supression d'une reservation
	 * 
	 * @param user_id --> id utilisateur
	 * @throws BibliothequeException 
	 */
	@WebMethod
	public List<Reservation> getListReservationByBook(@WebParam(name = "Book_ID") Long Book_ID) throws BibliothequeException {
	   return reservationBusiness.getListReservationByBook(Book_ID);
	}
	
}
