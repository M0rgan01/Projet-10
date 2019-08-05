package com.bibliotheque.metier;

import java.util.List;

<<<<<<< HEAD
=======
import com.bibliotheque.entities.Book;
>>>>>>> Ticket#2
import com.bibliotheque.entities.Reservation;
import com.bibliotheque.exception.BibliothequeException;

public interface ReservationBusiness {
	
	/**
	 * persistance d'une réservation
	 * 
	 * @param book_id --> livre correspondant
	 * @param user_id --> utilisateur correspondant
	 * 
	 * @throws BibliothequeException --> attributs book_id et user_id incorrect, réservation déjà effectué pour le livre, réservation non disponnible
	 * 
	 * @return Reservation 
	 */
	public Reservation createReservation(Long book_id, Long user_id) throws BibliothequeException;
	
	/**
<<<<<<< HEAD
	 * supression d'une réservation
=======
	 * suppression d'une réservation
	 * 
	 * @param book_id --> livre correspondant
	 * @param user_id --> utilisateur correspondant
	 * @throws BibliothequeException 
	 * 
	 * @return Book  
	 * 
	 */
	public Book deleteReservation(Long book_id, Long user_id) throws BibliothequeException;
	
	/**
	 * suppression d'une réservation pour son retard
>>>>>>> Ticket#2
	 * 
	 * @param book_id --> livre correspondant
	 * @param user_id --> utilisateur correspondant
	 * @throws BibliothequeException 
	 * 
	 */
<<<<<<< HEAD
	public void deleteReservation(Long book_id, Long user_id) throws BibliothequeException;
=======
	public void deleteReservationForLate(Long book_id, Long user_id) throws BibliothequeException;
>>>>>>> Ticket#2
	
	/**
	 * récupération de la liste de réservation d'un livre 
	 * 
	 * @param book_id --> livre correspondant
	 * 
	 * @return Liste de réservation 
	 * 
	 */
	public List<Reservation> getListReservationByBook(Long book_id);
	
	/**
	 * récupération de la liste de réservation d'un utilisateur 
	 * 
	 * @param user_id --> utilisateur correspondant
	 * 
	 * @return Liste de réservation 
	 * 
	 */
	public List<Reservation> getListReservationByUser(Long user_id);
	
	
	/**
	 * Met à jour la position des réservations d'un livre 
	 * 
	 * @param book_id --> livre correspondant
	 * 
	 * 
	 */
	public void setPositionOfReservation(Long book_id);
	
	/**
	 * Vérifie la présence de réservation pour un livre
	 * 
<<<<<<< HEAD
	 * @param book_id
	 * @throws BibliothequeException
	 */
	public void checkReservation(Long book_id) throws BibliothequeException;
=======
	 * @param book
	 * @throws BibliothequeException
	 */
	public void checkReservation(Book book) throws BibliothequeException;
>>>>>>> Ticket#2
	
	
	/**
	 * requete de recherche des reservations avec une date de fin fixé
	 * 
	 * 
	 * @return list de reservation
	 */
	public List<Reservation> getListReservationWithEndDate();
}
