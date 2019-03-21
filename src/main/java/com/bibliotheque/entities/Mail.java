package com.bibliotheque.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
public class Mail implements Serializable{
	@SequenceGenerator(name="MAIL_SEQ", sequenceName="mail_sequence")
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="MAIL_SEQ")
	private Long id;
	@Email(message="L'adresse email n'est pas conforme")
	@NotBlank(message="L'adresse email ne peut être vide")
	private String email;
	private String token;
	private int essaisToken;
	private Date expirationToken;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Utilisateur utilisateur;

	public Mail() {
		super();
	}

	public Mail(String email, Utilisateur utilisateur) {
		super();
		this.email = email;		
		this.utilisateur = utilisateur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getEssaisToken() {
		return essaisToken;
	}

	public void setEssaisToken(int essaisToken) {
		this.essaisToken = essaisToken;
	}

	public Date getExpirationToken() {
		return expirationToken;
	}

	public void setExpirationToken(Date expirationToken) {
		this.expirationToken = expirationToken;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}
