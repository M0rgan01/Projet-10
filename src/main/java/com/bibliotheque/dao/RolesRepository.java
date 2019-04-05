package com.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bibliotheque.entities.Roles;

public interface RolesRepository extends JpaRepository<Roles, String>{

	@Query("select r from User u join u.roles r where u.pseudo = :x")
	public List<Roles> getListRoles(@Param("x") String pseudo);
}
