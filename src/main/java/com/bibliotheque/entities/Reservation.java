package com.bibliotheque.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation implements Serializable{

	@Id @GeneratedValue
	private Long id;
	private Date debut;
	private Date fin;
	private boolean prolongation;
	private Date finProlongation;
	
	@ManyToOne
	@JoinColumn(name="UTILISATEUR_ID")
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="OUVRAGE_ID")
	private Ouvrage ouvrage;

	
	public Reservation() {
		super();
	}

	public Reservation(Date debut, Date fin, Utilisateur utilisateur, Ouvrage ouvrage) {
		super();
		this.debut = debut;
		this.fin = fin;
		this.utilisateur = utilisateur;
		this.ouvrage = ouvrage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public boolean isProlongation() {
		return prolongation;
	}

	public void setProlongation(boolean prolongation) {
		this.prolongation = prolongation;
	}

	public Date getFinProlongation() {
		return finProlongation;
	}

	public void setFinProlongation(Date finProlongation) {
		this.finProlongation = finProlongation;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Ouvrage getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}
	
	
}
