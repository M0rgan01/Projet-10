package com.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotheque.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, String>{

}
