package com.bibliotheque.dao;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bibliotheque.entities.Ouvrage;

public interface OuvrageRepository extends JpaRepository<Ouvrage, Long>{
	
	@Query("select o from Ouvrage o")
	public Page<Ouvrage> listOuvrage(Pageable pageable);
}
