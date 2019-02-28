package com.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotheque.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
