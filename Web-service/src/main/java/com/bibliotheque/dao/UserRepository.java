package com.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bibliotheque.entities.User;

/**
 * DAO Utilisateur 
 * 
 * @author PICHAT morgan
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{
	
	/**
	 * requete de recherche d'utilisateur
	 * 
	 * @param pseudo --> pseudo de l'utilisateur 
	 * 
	 * @return object utilisateur
	 */
	@Query("select u from User u where u.pseudo = :x")
	public User findByPseudo(@Param("x") String pseudo);
}
