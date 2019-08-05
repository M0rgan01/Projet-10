package com.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bibliotheque.entities.Reservation;

/**
 * DAO reservation 
 * 
 * @author PICHAT morgan
 *
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	
	/**
	 * requete de supression de reservation par rapport au livre et à l'utilisateur
	 * 
	 * @param book_id 
	 * @param user_id 
	 * 
	 */
	@Modifying
	@Query("delete from Reservation r where r.book.id = :x and r.user.id = :y")
	public void deleteByUserIdAndBookId(@Param("x") Long book_id, @Param("y")Long user_id);
	
	/**
	 * requete de recherche de Reservation par rapport à l'id utilisateur
	 * 
	 * @param user_id --> id de l'utilisateur 
	 * 
	 * @return object Reservation
	 */
	@Query("select r from Reservation r where r.book.id = :x and r.user.id = :y")
	public Reservation findByUserIdAndBookId(@Param("x") Long book_id, @Param("y")Long user_id);
	
	
	/**
	 * requete de recherche des reservations en cours pour un utilisateur
	 * 
	 * @param user_id --> id de l'utilisateur
	 * 
	 * @return list de reservation
	 */
	@Query("select r from Reservation r where r.user.id = :x")
	public List<Reservation> getListReservationByUserID(@Param("x")Long user_id);
	
	/**
	 * requete de recherche des reservations en cours pour un livre
	 * 
	 * @param book_id --> id du livre
	 * 
	 * @return list de reservation
	 */
	@Query("select r from Reservation r where r.book.id = :x order by r.startReservation")
	public List<Reservation> getListReservationByBookID(@Param("x")Long book_id);
	
	/**
	 * requete de recherche des reservations avec une date de fin fixé
	 * 
	 * 
	 * @return list de reservation
	 */
	@Query("select r from Reservation r where r.endReservation is not null")
	public List<Reservation> getListReservationWithEndDate();
	
	
}
