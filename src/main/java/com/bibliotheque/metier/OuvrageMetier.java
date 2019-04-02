package com.bibliotheque.metier;

import com.bibliotheque.entities.Ouvrage;
import com.bibliotheque.exception.BibliothequeException;

public interface OuvrageMetier {
	public void createOuvrage(Ouvrage ouvrage, String genre) throws BibliothequeException;
	public void saveOuvrage(Ouvrage ouvrage, String genre) throws BibliothequeException;
	public void saveOuvrage(Ouvrage ouvrage);
	public void deleteOuvrage(Long id);
	public Ouvrage getOuvrage(Long id);
	public PageOuvrage listOuvrage(String mc, String genre, boolean disponnible, int page, int size);
	public void validateOuvrage(Ouvrage ouvrage) throws BibliothequeException;
	
}
