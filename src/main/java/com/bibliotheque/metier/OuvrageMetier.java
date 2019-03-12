package com.bibliotheque.metier;

import com.bibliotheque.entities.Ouvrage;

public interface OuvrageMetier {
	public void saveOuvrage(Ouvrage ouvrage);
	public void deleteOuvrage(Long id);
	public Ouvrage getOuvrage(Long id);
	public PageOuvrage listOuvrage(String mc, int page, int size);
}
