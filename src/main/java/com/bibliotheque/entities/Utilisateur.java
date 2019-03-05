package com.bibliotheque.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Utilisateur implements Serializable{

	@Id @GeneratedValue
	private Long id;
	private String pseudo;
	private String passWord;
	private boolean active;
	private int essaisConnection; 
	private Date expirationConnection;
	@ManyToMany
	private Collection<Roles> roles = new HashSet<>();
	@OneToMany(mappedBy="utilisateur")
	private Collection<Reservation> reservations;
	
	
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(String pseudo, String passWord, boolean active) {
		super();
		this.pseudo = pseudo;
		this.passWord = passWord;
		this.active = active;		
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getEssaisConnection() {
		return essaisConnection;
	}
	public void setEssaisConnection(int essaisConnection) {
		this.essaisConnection = essaisConnection;
	}
	public Date getExpirationConnection() {
		return expirationConnection;
	}
	public void setExpirationConnection(Date expirationConnection) {
		this.expirationConnection = expirationConnection;
	}

	@XmlTransient
	public Collection<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}

	@XmlTransient
	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
}
