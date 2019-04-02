package com.bibliotheque.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Utilisateur implements Serializable{

	@SequenceGenerator(name="UTILISATEUR_SEQ", sequenceName="utilisateur_sequence")
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="UTILISATEUR_SEQ")
	private Long id;	
	@NotBlank(message="Le pseudo ne peut être vide")
	@Size(max=20, min=5, message="Le pseudo doit contenir minimun 5 caractères et maximum 20 caractères")
	private String pseudo;	
//	@NotBlank(message="Le mot de passe ne peut être vide")
//	@Size(max=20, min=8, message="Le mot de passe doit contenir minimun 8 caractères et maximum 20 caractères")
//	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$", message="Le mot de passe doit contenir au moin une minuscule, une majuscule, et un chiffre")	
	private String passWord;	
	@Transient
	private String passWordConfirm;
	@Transient
	private String oldPassWord;
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

	public String getPassWordConfirm() {
		return passWordConfirm;
	}

	public void setPassWordConfirm(String passWordConfirm) {
		this.passWordConfirm = passWordConfirm;
	}
	
	public String getOldPassWord() {
		return oldPassWord;
	}

	public void setOldPassWord(String oldPassWord) {
		this.oldPassWord = oldPassWord;
	}
}
