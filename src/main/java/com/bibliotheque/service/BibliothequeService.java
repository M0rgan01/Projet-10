package com.bibliotheque.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bibliotheque.entities.Genre;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Ouvrage;
import com.bibliotheque.entities.Reservation;
import com.bibliotheque.entities.Roles;
import com.bibliotheque.entities.Utilisateur;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.metier.GenreMetier;
import com.bibliotheque.metier.MailMetier;
import com.bibliotheque.metier.OuvrageMetier;
import com.bibliotheque.metier.PageOuvrage;
import com.bibliotheque.metier.ReservationMetier;
import com.bibliotheque.metier.RolesMetier;
import com.bibliotheque.metier.UtilisateurMetier;

@Component
@WebService(name = "BibliothequeWS")
public class BibliothequeService {

	@Autowired
	private UtilisateurMetier utilisateurMetier;
	@Autowired
	private MailMetier mailMetier;
	@Autowired
	private OuvrageMetier ouvrageMetier;
	@Autowired
	private GenreMetier genreMetier;
	@Autowired
	private ReservationMetier reservationMetier;
	@Autowired
	private RolesMetier rolesMetier;

//////////////////////// AUTHENTIFICATION - GESTION COMPTE UTILISATEUR ////////////////////////

	@WebMethod
	public void saveUtilisateur(@WebParam(name = "utilisateur") Utilisateur utilisateur) throws BibliothequeException {
		utilisateurMetier.saveUtilisateur(utilisateur);
	}

	@WebMethod
	public Utilisateur createUtilisateur(@WebParam(name = "utilisateur") Utilisateur utilisateur,
			@WebParam(name = "mail") Mail mail) throws BibliothequeException {
		return utilisateurMetier.createUtilisateur(utilisateur, mail);
	}

	@WebMethod
	public void deleteUtilisateur(@WebParam(name = "id") Long id) {
		mailMetier.deleteMailByUtilisateurID(id);
		utilisateurMetier.deleteUtilisateur(id);
	}

	@WebMethod
	public Utilisateur getUtilisateur(@WebParam(name = "id") Long id) {
		return utilisateurMetier.getUtilisateur(id);
	}

	@WebMethod
	public Utilisateur doConnection(@WebParam(name = "pseudo") String pseudo,
			@WebParam(name = "passWord") String passWord) throws BibliothequeException {
		return utilisateurMetier.doConnection(pseudo, passWord);
	}

	@WebMethod
	public void saveMail(@WebParam(name = "mail") Mail mail, @WebParam(name = "utilisateur_id") Long utilisateur_id)
			throws BibliothequeException {
		mailMetier.saveMail(mail, utilisateur_id);
	}

	@WebMethod
	public Mail getMail(@WebParam(name = "utilisateur_id") Long id) {
		return mailMetier.getMailByUtilisateurID(id);
	}

	@WebMethod
	public List<Roles> getListRoles(@WebParam(name = "pseudo") String pseudo) {
		return rolesMetier.getListRoles(pseudo);
	}

//////////////////////// GESTION OUVRAGE - RECHERCHE ////////////////////////
	
	
	@WebMethod
	public void createOuvrage(@WebParam(name = "ouvrage") Ouvrage ouvrage, @WebParam(name = "genre") String genre)
			throws BibliothequeException {
		ouvrageMetier.createOuvrage(ouvrage, genre);
	}

	@WebMethod
	public void updateOuvrage(@WebParam(name = "ouvrage") Ouvrage ouvrage, @WebParam(name = "genre") String genre)
			throws BibliothequeException {
		ouvrageMetier.saveOuvrage(ouvrage, genre);
	}

	@WebMethod
	public void deleteOuvrage(Long id) {
		ouvrageMetier.deleteOuvrage(id);
	}

	@WebMethod
	public Ouvrage getOuvrage(Long id) {
		return ouvrageMetier.getOuvrage(id);
	}

	@WebMethod
	public PageOuvrage listOuvrage(@WebParam(name = "mot-cle") String mc, @WebParam(name = "genre") String genre,
			@WebParam(name = "disponnible") boolean disponnible, @WebParam(name = "page") int page,
			@WebParam(name = "size") int size) {
		return ouvrageMetier.listOuvrage(mc, genre, disponnible, page, size);
	}

	@WebMethod
	public List<Genre> getListGenre() {
		return genreMetier.getListGenre();
	}

//////////////////////// GESTION RESERVATION ////////////////////////
	
	
	@WebMethod
	public void createReservation(@WebParam(name = "reservation") Reservation reservation,
			@WebParam(name = "ouvrage_id") Long ouvrage_id, @WebParam(name = "utilisateur_id") Long utilisateur_id)
			throws BibliothequeException {
		reservationMetier.createReservation(ouvrage_id, utilisateur_id, reservation);
	}

	@WebMethod
	public void deleteReservation(Long id) {
		reservationMetier.deleteReservation(id);
	}

	@WebMethod
	public Reservation getReservation(Long id) {
		return reservationMetier.getRerservation(id);
	}

	@WebMethod
	public List<Reservation> getListReservationByUtilisateurID(@WebParam(name = "utilisateur_id") Long utilisateur_id) {
		return reservationMetier.getListReservationByUtilisateurID(utilisateur_id);
	}

	@WebMethod
	public List<Reservation> getListReservationRetardedByUtilisateurID(
			@WebParam(name = "utilisateur_id") Long utilisateur_id) {
		return reservationMetier.getListReservationRetardedByUtilisateurID(utilisateur_id);
	}

	@WebMethod
	public void prolongerReservation(Long reservationID, Long utilisateurID) throws BibliothequeException {
		reservationMetier.prolongerReservation(reservationID, utilisateurID);
	}

	@WebMethod
	public int getDaysProlongation() throws BibliothequeException {
		return reservationMetier.getDaysProlongation();
	}

}
