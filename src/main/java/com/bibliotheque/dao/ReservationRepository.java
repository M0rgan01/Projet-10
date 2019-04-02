package com.bibliotheque.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bibliotheque.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	@Query("select count(r.id) from Reservation r where not (r.debut > :d or r.fin < :f)")
	public int getContReservation(@Param("d") Date debut, @Param("f") Date fin);
	
	
}
