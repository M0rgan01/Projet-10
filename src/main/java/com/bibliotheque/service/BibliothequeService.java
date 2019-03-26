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

	@WebMethod
	public void saveUtilisateur(@WebParam(name = "utilisateur") Utilisateur utilisateur) {
		utilisateurMetier.saveUtilisateur(utilisateur);
	}

	@WebMethod
	public void createUtilisateur(@WebParam(name = "utilisateur") Utilisateur utilisateur,
			@WebParam(name = "mail") Mail mail) throws BibliothequeException {
		utilisateurMetier.createUtilisateur(utilisateur, mail);
	}

	@WebMethod
	public void deleteUtilisateur(@WebParam(name = "id") Long id) {
		utilisateurMetier.deleteUtilisateur(id);
	}

	@WebMethod
	public Utilisateur doConnection(@WebParam(name = "pseudo") String pseudo,
			@WebParam(name = "passWord") String passWord) throws BibliothequeException {
		return utilisateurMetier.doConnection(pseudo, passWord);
	}

	@WebMethod
	public void saveMail(Mail mail) {
		mailMetier.saveMail(mail);
	}

	@WebMethod
	public void deleteMail(Long id) {
		mailMetier.deleteMail(id);
	}

	@WebMethod
	public Mail getMail(@WebParam(name = "pseudo") String email) {
		return mailMetier.getMail(email);
	}

	@WebMethod
	public void createOuvrage(@WebParam(name = "ouvrage")Ouvrage ouvrage, @WebParam(name = "genre") String genre) throws BibliothequeException {
		ouvrageMetier.createOuvrage(ouvrage, genre);
	}

	@WebMethod
	public void updateOuvrage(@WebParam(name = "ouvrage")Ouvrage ouvrage, @WebParam(name = "genre") String genre) throws BibliothequeException {
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
	public void saveGenre(Genre genre) {
		genreMetier.saveGenre(genre);
	}

	@WebMethod
	public List<Genre> getListGenre() {
		return genreMetier.getListGenre();
	}

	@WebMethod
	public Genre getGenre(String nom) {
		return genreMetier.getGenre(nom);
	}

	@WebMethod
	public void saveReservation(Reservation reservation) {
		reservationMetier.saveReservation(reservation);
	}

	@WebMethod
	public void deleteReservation(Long id) {
		reservationMetier.deleteReservation(id);
	}

	@WebMethod
	public Reservation getRerservation(Long id) {
		return reservationMetier.getRerservation(id);
	}

	@WebMethod
	public List<Roles> getListRoles(@WebParam(name = "pseudo") String pseudo) {
		return rolesMetier.getListRoles(pseudo);
	}

}
