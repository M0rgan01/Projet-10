package com.bibliotheque.metier;

import org.springframework.data.domain.Page;

import com.bibliotheque.entities.Ouvrage;

public interface OuvrageMetier {
	public void saveOuvrage(Ouvrage ouvrage);
	public void deleteOuvrage(Long id);
	public Ouvrage getOuvrage(Long id);
	public Page<Ouvrage> listOuvrage(int page, int size);
}
