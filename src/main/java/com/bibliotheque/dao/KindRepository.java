package com.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotheque.entities.Kind;

/**
 * DAO genre
 * 
 * @author PICHAT morgan
 *
 */
public interface KindRepository extends JpaRepository<Kind, String>{

}
