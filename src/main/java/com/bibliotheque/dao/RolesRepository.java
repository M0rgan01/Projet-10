package com.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotheque.entities.Roles;

public interface RolesRepository extends JpaRepository<Roles, String>{

}
