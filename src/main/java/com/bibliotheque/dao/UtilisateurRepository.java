package com.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bibliotheque.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	
	@Query("select u from Utilisateur u where u.pseudo = :x")
	public Utilisateur findByPseudo(@Param("x") String pseudo);
}
