package com.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bibliotheque.entities.Mail;
/**
 * DAO mail 
 * 
 * @author PICHAT morgan
 *
 */
public interface MailRepository extends JpaRepository<Mail, Long>{

	/**
	 * requete de recherche de mail par rapport à l'attribut email
	 * 
	 * @param email 
	 * 
	 * @return object mail
	 */
	@Query("select m from Mail m where m.email = :x")
	public Mail findByEmail(@Param("x") String email);
	
	/**
	 * requete de recherche de mail par rapport à l'id utilisateur
	 * 
	 * @param user_id --> id de l'utilisateur 
	 * 
	 * @return object mail
	 */
	@Query("select m from Mail m where m.user.id = :x")
	public Mail findByUserID(@Param("x")Long user_id);
	
}
