package com.bibliotheque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.GenreRepository;
import com.bibliotheque.entities.Genre;

@Service
public class GenreMetierImpl implements GenreMetier{

	@Autowired
	private GenreRepository genreRepository;
	
	@Override
	public void saveGenre(Genre genre) {
		genreRepository.save(genre);
	}

	@Override
	public List<Genre> getListGenre() {		
		return genreRepository.findAll();
	}

	@Override
	public Genre getGenre(String nom) {		
		return genreRepository.findById(nom).orElse(null);
	}

}
