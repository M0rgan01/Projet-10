package com.bibliotheque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Ouvrage implements Serializable{

	@SequenceGenerator(name="OUVRAGE_SEQ", sequenceName="ouvrage_sequence")
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="OUVRAGE_SEQ")
	private Long id;
	private String nom;
	private String auteur;
	private String description;
	private boolean disponible;
	
	@OneToMany(mappedBy="ouvrage")
	private Collection<Reservation> reservations;
	
	@ManyToOne
	@JoinColumn(name="GENRE_NOM")
	private Genre genre;

	
	public Ouvrage() {
		super();
	}

	public Ouvrage(String nom, String auteur, String description, boolean disponible, Genre genre) {
		super();
		this.nom = nom;
		this.auteur = auteur;
		this.description = description;
		this.disponible = disponible;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@XmlTransient
	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
	
}
