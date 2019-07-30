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
	
	/**
	 * Date de creation de la reservation
	 */	
	private Date startReservation;
	/**
	 * position d'une reservation parmit les autres
	 */
	private int position;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "BOOK_ID")
	private Book book;
	
	
	public Reservation() {}
	
	public Reservation(Date start, User user, Book book) {
		this.startReservation = start;	
		this.book = book;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartReservation() {
		return startReservation;
	}

	public void setStartReservation(Date startReservation) {
		this.startReservation = startReservation;
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

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	
	
	
}

