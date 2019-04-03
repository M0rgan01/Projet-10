package com.bibliotheque.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bibliotheque.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	@Query("select count(r.id) from Reservation r where not (r.debut > :d or r.fin < :f)")
	public int getContReservation(@Param("d") Date debut, @Param("f") Date fin);
	
	//recupere list des reservations en cours pour un utilisateur
	@Query("select r from Reservation r where r.utilisateur.id = :x and r.fin > :y and rendu = false")
	public List<Reservation> getListReservationByUtilisateurID(@Param("x")Long utilisateur_id, @Param("y")Date now);
	
	//recupere list des reservations en retard pour un utilisateur
	@Query("select r from Reservation r where r.utilisateur.id = :x and r.fin < :y and rendu = false")
	public List<Reservation> getListReservationRetardedByUtilisateurID(@Param("x")Long utilisateur_id, @Param("y")Date now);
}
