package com.bibliotheque.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Object representant un livre
 * 
 * @author PICHAT morgan
 *
 */
@Entity
public class Book implements Serializable{

	@SequenceGenerator(name="BOOK_SEQ", sequenceName="book_sequence")
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="BOOK_SEQ")
	private Long id;
	@NotBlank(message="book.title.blank")
	@Size(max=50, min=5, message="book.title.size.not.correct")
	private String title;
	@NotBlank(message="book.author.blank")
	@Size(max=20, message="book.author.size.not.correct")
	private String author;
	@NotBlank(message="book.description.blank")
	@Size(max=500, message="book.descritpion.size.not.correct")
	@Column(length=2000)
	private String description;
	
	/**
	 * Nombre de copies totals 
	 */
	@Min(value=1, message="book.copyTotals.value.not.correct")
	private int copyTotals;
	/**
	 * Nombre de copies disponible  
	 */
	private int copyAvailable;
	/**
	 * boolean de disponibilité pour emprunt 
	 */
	private boolean available;
	/**
	 * boolean de désactivation  
	 */	
	private boolean disable;
	/**
	 * Date de retour d'emprunt la plus proche 
	 */	
	private Date loanBack;
	/**
	 * Nombre de reservation en cour du livre
	 */	
	private int numberReservation;
	/**
	 * boolean de disponibilité pour reservation  
	 */
	private boolean availableReservation;
	
	@OneToMany(mappedBy="book")
	private Collection<Loan> loans;
	
	@OneToMany(mappedBy="book")
	private Collection<Reservation> reservations;
	
	@ManyToOne
	@JoinColumn(name="KIND_NAME")
	@NotNull(message="book.kind.null")
	private Kind kind;

	
	public Book() {
		super();
	}

	public Book(String title, String author, String description, boolean available, Kind kind,int copyTotals, int copyAvailable) {
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
	
	@XmlTransient
	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public Date getLoanBack() {
		return loanBack;
	}

	public void setLoanBack(Date loanBack) {
		this.loanBack = loanBack;
	}

	public int getNumberReservation() {
		return numberReservation;
	}

	public void setNumberReservation(int numberReservation) {
		this.numberReservation = numberReservation;
	}

	public boolean isAvailableReservation() {
		return availableReservation;
	}

	public void setAvailableReservation(boolean availableReservation) {
		this.availableReservation = availableReservation;
	}

		
}
