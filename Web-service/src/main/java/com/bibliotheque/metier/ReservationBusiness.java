package com.bibliotheque.metier;

import java.util.List;

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
	 * supression d'une réservation
	 * 
	 * @param book_id --> livre correspondant
	 * @param user_id --> utilisateur correspondant
	 * 
	 */
	public void deleteReservation(Long book_id, Long user_id);
	
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
}
