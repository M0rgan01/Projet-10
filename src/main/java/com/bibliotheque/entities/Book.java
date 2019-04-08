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
public class Book implements Serializable{

	@SequenceGenerator(name="BOOK_SEQ", sequenceName="book_sequence")
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="BOOK_SEQ")
	private Long id;
	@NotBlank(message="Le titre du livre ne peut être vide")
	@Size(max=20, min=5, message="Le titre doit contenir minimun 5 caractères et maximum 20 caractères")
	private String title;
	@NotBlank(message="L'auteur du livre ne peut être vide")
	@Size(max=20, message="L'auteur ne peut pas éxéder 20 caractères")
	private String author;
	@NotBlank(message="La description du livre ne peut être vide")
	@Size(max=500, message="La description ne peut pas éxéder 500 caractères")
	private String description;
	private int copyTotals;
	private int copyAvailable;
	private boolean available;
		
	@OneToMany(mappedBy="book")
	private Collection<Loan> loans;
	
	@ManyToOne
	@JoinColumn(name="KIND_NAME")
	private Kind kind;

	
	public Book() {
		super();
	}

	public Book(String title, String author, String description, boolean available, Kind kind, int copyTotals, int copyAvailable) {
		super();
		this.title = title;
		this.author = author;
		this.description = description;
		this.available = available;
		this.kind = kind;
		this.copyTotals = copyTotals;
		this.copyAvailable = copyAvailable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCopyTotals() {
		return copyTotals;
	}

	public void setCopyTotals(int copyTotals) {
		this.copyTotals = copyTotals;
	}

	public int getCopyAvailable() {
		return copyAvailable;
	}

	public void setCopyAvailable(int copyAvailable) {
		this.copyAvailable = copyAvailable;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@XmlTransient
	public Collection<Loan> getLoans() {
		return loans;
	}

	public void setLoans(Collection<Loan> loans) {
		this.loans = loans;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	
		
}
