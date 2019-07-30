package com.bibliotheque.metier;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bibliotheque.dao.BookRepository;
import com.bibliotheque.dao.ReservationRepository;
import com.bibliotheque.entities.Book;
import com.bibliotheque.entities.Reservation;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;

@Component
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
	public Reservation createReservation(Long book_id, Long user_id) throws BibliothequeException {
		User user = userBusiness.getUser(user_id);
		Book book = bookBusiness.getBook(book_id);
		Reservation reservationByUser = reservationRepository.findByUserIdAndBookId(book_id, user_id);
		Reservation reservation;
		
		//on vérifie que l'utilisateur n'à pas déjà une réservation pour ce livre
		if(reservationByUser != null) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("49");
			bibliothequeFault.setFaultString("reservation.user.already.here");
			throw new BibliothequeException("reservation.user.already.here", bibliothequeFault);
		}
		
		
		// si le livre est disponnible pour réservation
		if(book.isAvailableReservation()) {
			reservation = new Reservation(new Date(), user, book);			
			reservationRepository.save(reservation);
			logger.info("Success create reservation" + reservation.getId());
			book.setNumberReservation(book.getNumberReservation()+1);
						
			//si le nombre de réservation devient supérieur ou égal au nombre de copie total x2
			if (book.getNumberReservation() >= book.getCopyTotals()*2) {
				book.setAvailableReservation(false);
			}		
			
			bookRepository.save(book);
			logger.info("Success update book" + book.getId());
		}else {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("50");
			bibliothequeFault.setFaultString("reservation.not.possible");
			throw new BibliothequeException("reservation.not.possible", bibliothequeFault);
		}
		setPositionOfReservation(book_id);
		logger.info("Update position of reservation for book " + book_id);
		return reservation;
	}

	@Override
	public void deleteReservation(Long book_id, Long user_id) {
		reservationRepository.deleteByUserIdAndBookId(book_id, user_id);	
		logger.info("Success delete reservation");
		setPositionOfReservation(book_id);
		logger.info("Update position of reservation for book " + book_id);
	}

	@Override
	public List<Reservation> getListReservationByBook(Long book_id) {			
		return reservationRepository.getListReservationByBookID(book_id);
	}
	
	
	public synchronized void setPositionOfReservation(Long book_id) {
		int index = 0;		
		List<Reservation> list = reservationRepository.getListReservationByBookID(book_id);
		for (Reservation reservation : list) {
			reservation.setPosition(index++);			
		}		
		reservationRepository.saveAll(list);
	}

	@Override
	public List<Reservation> getListReservationByUser(Long user_id) {		
		return reservationRepository.getListReservationByUserID(user_id);
	}
	
	
}
