package com.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotheque.entities.Kind;

public interface KindRepository extends JpaRepository<Kind, String>{

}
