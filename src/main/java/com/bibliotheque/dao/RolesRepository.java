package com.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bibliotheque.entities.Roles;

/**
 * DAO Roles 
 * 
 * @author PICHAT morgan
 *
 */
public interface RolesRepository extends JpaRepository<Roles, String>{

	
	/**
	 * requete de recherche de Roles par rapport à un utilisateur
	 * 
	 * @param pseudo --> pseudo de l'utilisateur 
	 * 
	 * @return list de Roles
	 */
	@Query("select r from User u join u.roles r where u.pseudo = :x")
	public List<Roles> getListRoles(@Param("x") String pseudo);
}
