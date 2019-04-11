package com.bibliotheque.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Object representant un Role
 * 
 * @author PICHAT morgan
 *
 */
@Entity
public class Roles implements Serializable{

	@Id
	private String role;
	
	public Roles() {
		super();
	}

	public Roles(String role) {
		super();
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
