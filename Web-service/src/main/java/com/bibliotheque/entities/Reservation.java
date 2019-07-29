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
 * Object representant une réservation
 * 
 * @author PICHAT morgan
 *
 */
@Entity
public class Reservation implements Serializable{

	
	@SequenceGenerator(name="MAIL_SEQ", sequenceName="mail_sequence")
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="RESERVATION_SEQ")
	private Long id;
	
	private Date start_reservation;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "BOOK_ID")
	private Book book;
	
	
	public Reservation() {}
	
	public Reservation(Date start, User user, Book book) {
		this.start_reservation = start;	
		this.book = book;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStart_reservation() {
		return start_reservation;
	}

	public void setStart_reservation(Date start_reservation) {
		this.start_reservation = start_reservation;
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

