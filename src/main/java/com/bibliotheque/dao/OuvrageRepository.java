package com.bibliotheque.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bibliotheque.entities.Ouvrage;

public interface OuvrageRepository extends JpaRepository<Ouvrage, Long>{
	
	@Query("select o from Ouvrage o where o.nom like :x order by o.nom")
	public Page<Ouvrage> listOuvrage(@Param("x") String mc, Pageable pageable);
}
