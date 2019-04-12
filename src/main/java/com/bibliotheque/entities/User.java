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
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Object representant un utilisateur
 * 
 * @author PICHAT morgan
 *
 */
@Entity
@Table(name="USERS")
public class User implements Serializable{

	@SequenceGenerator(name="USER_ID", sequenceName="user_sequence")
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="USER_SEQ")
	private Long id;	
	@NotBlank(message="user.pseudo.blank")
	@Size(max=20, min=5, message="user.pseudo.size.not.correct")
	private String pseudo;		
	private String passWord;	
	@Transient
	private String passWordConfirm;
	@Transient
	private String oldPassWord;
	/**
	 * Boolean représentant la permission de connection
	 */
	private boolean active;
	/**
	 * Nombre d'échec de connection
	 */
	private int tryConnection; 
	/**
	 * Date d'expiration lors d'un nombre d'échec trop grand
	 */
	private Date expiryConnection;
	
	@ManyToMany
	private Collection<Roles> roles = new HashSet<>();
	
	@OneToMany(mappedBy="user")
	private Collection<Loan> loans;
	
	
	public User() {
		super();
	}
	
	public User(String pseudo, String passWord, boolean active) {
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getTryConnection() {
		return tryConnection;
	}

	public void setTryConnection(int tryConnection) {
		this.tryConnection = tryConnection;
	}

	public Date getExpiryConnection() {
		return expiryConnection;
	}

	public void setExpiryConnection(Date expiryConnection) {
		this.expiryConnection = expiryConnection;
	}

	//@XmlTransient
	public Collection<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}
	@XmlTransient
	public Collection<Loan> getLoans() {
		return loans;
	}

	public void setLoans(Collection<Loan> loans) {
		this.loans = loans;
	}
	
	
	

}
