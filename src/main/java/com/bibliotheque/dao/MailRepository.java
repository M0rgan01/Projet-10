package com.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bibliotheque.entities.Mail;

public interface MailRepository extends JpaRepository<Mail, Long>{

	@Query("select m from Mail m where m.email = :x")
	public Mail findByEmail(@Param("x") String email);
	
	@Query("select m from Mail m where m.user.id = :x")
	public Mail findByUserID(@Param("x")Long user_id);
	
}
