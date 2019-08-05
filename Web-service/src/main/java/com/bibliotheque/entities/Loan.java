package com.bibliotheque.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * Object representant un emprunt
 * 
 * @author PICHAT morgan
 *
 */
@Entity
public class Loan implements Serializable {

	@SequenceGenerator(name = "LOAN_SEQ", sequenceName = "loan_sequence")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOAN_SEQ")
	private Long id;
	/**
	 * Date de début d'emprunt  
	 */
	private Date start_loan;
	/**
	 * Date de fin d'emprunt  
	 */
	private Date end_loan;
	/**
	 * Boolean représentant l'extention d'un emprunt  
	 */
	private boolean extension;
	/**
	 * Boolean représentant le fait qu'un emprunt soit rendu
	 */
	private boolean made;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name = "BOOK_ID")
	private Book book;

	public Loan() {
		super();
	}

	public Loan(Date start_loan, Date end_loan, User user, Book book) {
		super();
		this.start_loan = start_loan;
		this.end_loan = end_loan;
		this.user = user;
		this.book = book;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStart_loan() {
		return start_loan;
	}

	public void setStart_loan(Date start_loan) {
		this.start_loan = start_loan;
	}

	public Date getEnd_loan() {
		return end_loan;
	}

	public void setEnd_loan(Date end_loan) {
		this.end_loan = end_loan;
	}

	public boolean isExtension() {
		return extension;
	}

	public void setExtension(boolean extension) {
		this.extension = extension;
	}

	public boolean isMade() {
		return made;
	}

	public void setMade(boolean made) {
		this.made = made;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	
	
	
}
