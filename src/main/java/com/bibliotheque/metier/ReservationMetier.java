package com.bibliotheque.metier;

import com.bibliotheque.entities.Reservation;
import com.bibliotheque.exception.BibliothequeException;

public interface ReservationMetier {
	public void saveReservation(Reservation reservation); 
	public void deleteReservation(Long id);
	public Reservation getRerservation(Long id);
	public void createReservation(Long ouvrage_id, Long utilisateur_id, Reservation reservation) throws BibliothequeException;
}
