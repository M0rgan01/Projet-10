package com.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotheque.entities.Ouvrage;

public interface OuvrageRepository extends JpaRepository<Ouvrage, Long>{

}
