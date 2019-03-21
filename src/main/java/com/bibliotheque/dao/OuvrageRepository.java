package com.bibliotheque.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bibliotheque.entities.Ouvrage;

public interface OuvrageRepository extends JpaRepository<Ouvrage, Long>{
	
	@Query("select o from Ouvrage o join o.genre g where (lower(o.nom) like lower(:x) or lower(o.auteur) like lower(:x)) and g.nom like :y and o.disponible = :d order by o.nom ")
	public Page<Ouvrage> getListOuvrages(@Param("x") String mc, @Param("y") String genre, @Param("d")boolean isReserved, Pageable pageable);
	@Query("select o from Ouvrage o join o.genre g where (lower(o.nom) like lower(:x) or lower(o.auteur) like lower(:x)) and g.nom like :y order by o.nom ")
	public Page<Ouvrage> getListOuvrages(@Param("x") String mc, @Param("y") String genre, Pageable pageable);
}
