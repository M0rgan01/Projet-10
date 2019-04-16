package com.bibliotheque.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Object representant une bibliotheque
 * 
 * @author PICHAT morgan
 *
 */
@Entity
public class Library implements Serializable{

	@SequenceGenerator(name="LIBRARY_SEQ", sequenceName="library_sequence")
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="LIBRARY_SEQ")
	private Long id;
	@NotBlank(message="library.name.blank")
	private String name;
	private String address;
	private String postalCode;
	private String streetNumber;
	private String city;
	
	@OneToMany(mappedBy="library")
	private List<Book> books;

	public Library() {
		super();
	}

	public Library(String name, String address, String postalCode,
			String streetNumber,String city) {
		super();
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
		this.streetNumber = streetNumber;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	@XmlTransient
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
