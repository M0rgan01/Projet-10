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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Ouvrage implements Serializable{

	@SequenceGenerator(name="OUVRAGE_SEQ", sequenceName="ouvrage_sequence")
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="OUVRAGE_SEQ")
	private Long id;
	@NotBlank(message="Le titre du livre ne peut être vide")
	@Size(max=20, min=5, message="Le titre doit contenir minimun 5 caractères et maximum 20 caractères")
	private String titre;
	@NotBlank(message="L'auteur du livre ne peut être vide")
	@Size(max=20, message="L'auteur ne peut pas éxéder 20 caractères")
	private String auteur;
	@NotBlank(message="La description du livre ne peut être vide")
	@Size(max=500, message="La description ne peut pas éxéder 500 caractères")
	private String description;
	private int exemplaireTotaux;
	private int exemplaireDisponible;
	private boolean disponible;
		
	@OneToMany(mappedBy="ouvrage")
	private Collection<Reservation> reservations;
	
	@ManyToOne
	@JoinColumn(name="GENRE_NOM")
	private Genre genre;

	
	public Ouvrage() {
		super();
	}

	public Ouvrage(String titre, String auteur, String description, boolean disponible, Genre genre, int exemplaireTotaux) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.description = description;
		this.disponible = disponible;
		this.genre = genre;
		this.exemplaireTotaux = exemplaireTotaux;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
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

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public int getExemplaireTotaux() {
		return exemplaireTotaux;
	}

	public void setExemplaireTotaux(int exemplaireTotaux) {
		this.exemplaireTotaux = exemplaireTotaux;
	}

	public int getExemplaireDisponible() {
		return exemplaireDisponible;
	}

	public void setExemplaireDisponible(int exemplaireDisponible) {
		this.exemplaireDisponible = exemplaireDisponible;
	}

	@XmlTransient
	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
	
		
}
