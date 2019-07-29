package com.bibliotheque.metier;

import com.bibliotheque.exception.BibliothequeException;

public interface ReservationBusiness {

	public void createReservation(Long book_id, Long user_id) throws BibliothequeException;
	public void deleteReservation(Long book_id, Long user_id) throws BibliothequeException;
}
