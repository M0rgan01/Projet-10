package com.bibliotheque.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.ReservationRepository;
import com.bibliotheque.entities.Reservation;

@Service
public class ReservationMetierImpl implements ReservationMetier{

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public void saveReservation(Reservation reservation) {
		reservationRepository.save(reservation);
	}

	@Override
	public void deleteReservation(Long id) {
		reservationRepository.deleteById(id);
	}

	@Override
	public Reservation getRerservation(Long id) {		
		return reservationRepository.findById(id).orElse(null);
	}

	@Override
	public boolean isDisponnible(Long id, Date date) {
		// TODO Auto-generated method stub
		return false;
	}

}
