package com.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotheque.entities.Library;

public interface LibraryRepository extends JpaRepository<Library, Long> {}
