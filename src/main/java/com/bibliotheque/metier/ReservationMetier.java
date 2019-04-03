package com.bibliotheque.metier;

import java.util.List;

import com.bibliotheque.entities.Reservation;
import com.bibliotheque.exception.BibliothequeException;

public interface ReservationMetier {
	public void prolongerReservation(Long reservationID, Long utilisateurID) throws BibliothequeException; 
	public void deleteReservation(Long id);
	public Reservation getRerservation(Long id);
	public void createReservation(Long ouvrage_id, Long utilisateur_id, Reservation reservation) throws BibliothequeException;
	public List<Reservation> getListReservationByUtilisateurID(Long utilisateur_id);
	public List<Reservation> getListReservationRetardedByUtilisateurID(Long utilisateur_id);
	public int getDaysProlongation();
}
