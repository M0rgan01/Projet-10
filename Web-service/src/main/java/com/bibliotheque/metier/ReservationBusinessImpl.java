package com.bibliotheque.metier;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bibliotheque.dao.BookRepository;
import com.bibliotheque.dao.ReservationRepository;
import com.bibliotheque.entities.Book;
import com.bibliotheque.entities.Reservation;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;

public class ReservationBusinessImpl implements ReservationBusiness{

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private BookBusiness bookBusiness;
	@Autowired
	private UserBusiness userBusiness;
	@Autowired
	private BookRepository bookRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationBusinessImpl.class);
	
	
	@Override
	@Transactional
	public void createReservation(Long book_id, Long user_id) throws BibliothequeException {
		User user = userBusiness.getUser(user_id);
		Book book = bookBusiness.getBook(book_id);
		
		if(book.isAvailableReservation()) {
			Reservation reservation = new Reservation(new Date(), user, book);
			reservationRepository.save(reservation);
			book.setNumberReservation(book.getNumberReservation()+1);
			
			if (book.getNumberReservation() >= book.getCopyTotals()*2) {
				book.setAvailableReservation(false);
			}			
			bookRepository.save(book);
		}
		
	}

	@Override
	public void deleteReservation(Long book_id, Long user_id) throws BibliothequeException {
		reservationRepository.deleteByUserIdAndBookId(book_id, user_id);
			
	}

}
