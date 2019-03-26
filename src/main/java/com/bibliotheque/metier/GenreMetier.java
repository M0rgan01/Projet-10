package com.bibliotheque.metier;

import java.util.List;

import com.bibliotheque.entities.Genre;
import com.bibliotheque.exception.BibliothequeException;

public interface GenreMetier {

	public void saveGenre(Genre genre);
	public List<Genre> getListGenre();
	public Genre getGenre(String nom);
	public void validateGenre(Genre genre) throws BibliothequeException;
}
