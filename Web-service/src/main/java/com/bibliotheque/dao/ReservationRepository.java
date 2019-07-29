package com.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
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
	@Query("delete from Reservation r where r.book.id = :x and r.user.id = :y")
	public void deleteByUserIdAndBookId(@Param("x") Long book_id, @Param("y")Long user_id);
}
