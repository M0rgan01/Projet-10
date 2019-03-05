package com.bibliotheque.metier;

import java.util.Date;

import com.bibliotheque.entities.Reservation;

public interface ReservationMetier {
	public void saveReservation(Reservation reservation); 
	public void deleteReservation(Long id);
	public Reservation getRerservation(Long id);
	public boolean isDisponnible(Long id, Date date);
}
