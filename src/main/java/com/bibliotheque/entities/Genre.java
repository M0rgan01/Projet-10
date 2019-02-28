package com.bibliotheque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre implements Serializable{

	@Id
	private String nom;
	
	@OneToMany(mappedBy="genre")
	private Collection<Ouvrage> ouvrages;

	public Genre() {
		super();
	}

	public Genre(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Ouvrage> getOuvrages() {
		return ouvrages;
	}

	public void setOuvrages(Collection<Ouvrage> ouvrages) {
		this.ouvrages = ouvrages;
	}
	
	
}
