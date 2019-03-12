package com.bibliotheque.metier;

import com.bibliotheque.entities.Reservation;

public interface ReservationMetier {
	public void saveReservation(Reservation reservation); 
	public void deleteReservation(Long id);
	public Reservation getRerservation(Long id);
}
