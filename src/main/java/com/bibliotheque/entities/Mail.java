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

/**
 * Object representant un Mail
 * 
 * @author PICHAT morgan
 *
 */
@Entity
public class Mail implements Serializable{
	
	@SequenceGenerator(name="MAIL_SEQ", sequenceName="mail_sequence")
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="MAIL_SEQ")
	private Long id;
	@Email(message="L'adresse email n'est pas conforme")
	@NotBlank(message="L'adresse email ne peut être vide")
	private String email;
	
	/**
	 * Token de récupération de mot de passe par email  
	 */
	private String token;
	/**
	 * Nombre d'éssais de vérification de token
	 */
	private int tryToken;
	/**
	 * Durée de validité du token
	 */
	private Date expiryToken;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	public Mail() {
		super();
	}

	public Mail(String email, User user) {
		super();
		this.email = email;		
		this.user = user;
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

	public int getTryToken() {
		return tryToken;
	}

	public void setTryToken(int tryToken) {
		this.tryToken = tryToken;
	}

	public Date getExpiryToken() {
		return expiryToken;
	}

	public void setExpiryToken(Date expiryToken) {
		this.expiryToken = expiryToken;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
