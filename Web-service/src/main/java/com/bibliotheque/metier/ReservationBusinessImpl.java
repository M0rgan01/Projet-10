package com.bibliotheque.metier;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bibliotheque.dao.BookRepository;
import com.bibliotheque.dao.ReservationRepository;
import com.bibliotheque.entities.Book;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Reservation;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;
import com.bibliotheque.utilities.Jasypt;
import com.bibliotheque.utilities.SendMail;

@Component
public class ReservationBusinessImpl implements ReservationBusiness {

	@Value("${mail.username}")
	private String emailUsers;
	@Value("${mail.password}")
	private String emailPassword;
	@Value("${mail.object.reservation}")
	private String objectRecovery;
	@Value("${mail.body.reservation}")
	private String bodyRecovery;
	@Value("${reservation.reset.hour}")
	private int resetReservationToHour;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private BookBusiness bookBusiness;
	@Autowired
	private UserBusiness userBusiness;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private MailBusiness mailBusiness;
	@Autowired
	private SendMail sendMail;
	@Autowired
	private Jasypt jasypt;

	private static final Logger logger = LoggerFactory.getLogger(ReservationBusinessImpl.class);

	@Override
	@Transactional
	public Reservation createReservation(Long book_id, Long user_id) throws BibliothequeException {
		User user = userBusiness.getUser(user_id);
		Book book = bookBusiness.getBook(book_id);
		Reservation reservationByUser = reservationRepository.findByUserIdAndBookId(book_id, user_id);
		Reservation reservation;

		// on vérifie que l'utilisateur n'à pas déjà une réservation pour ce livre
		if (reservationByUser != null) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("49");
			bibliothequeFault.setFaultString("reservation.user.already.here");
			throw new BibliothequeException("reservation.user.already.here", bibliothequeFault);
		}

		// si le livre est disponnible pour réservation
		if (book.isAvailableReservation() && !book.isAvailable()) {
			reservation = new Reservation(new Date(), user, book);
			reservationRepository.save(reservation);
			logger.info("Success create reservation" + reservation.getId());
			book.setNumberReservation(book.getNumberReservation() + 1);

			// si le nombre de réservation devient supérieur ou égal au nombre de copie
			// total x2
			if (book.getNumberReservation() >= book.getCopyTotals() * 2) {
				book.setAvailableReservation(false);
			}

			bookRepository.save(book);
			logger.info("Success update book" + book.getId());
		} else {
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
	@Transactional
	public synchronized Book deleteReservation(Long book_id, Long user_id) throws BibliothequeException {
		// suppression de la résa
		int a = reservationRepository.deleteByUserIdAndBookId(book_id, user_id);

		if (a == 0) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("60");
			bibliothequeFault.setFaultString("reservation.not.exist");
			throw new BibliothequeException("reservation.not.exist", bibliothequeFault);
		}

		logger.info("Success delete reservation");

		// on met à jour le nombre de réservation du livre
		Book book = bookBusiness.getBook(book_id);
		book.setNumberReservation(book.getNumberReservation() - 1);				
		book.setAvailableReservation(true);

		// réatribution des positions de la file d'attente
		setPositionOfReservation(book_id);
		logger.info("Update position of reservation for book " + book_id);

		return bookRepository.save(book);
	}

	@Override
	public void deleteReservationForLate(Long book_id, Long user_id) throws BibliothequeException {
		Book book = deleteReservation(book_id, user_id);
		checkReservation(book);
	}

	@Override
	public List<Reservation> getListReservationByBook(Long book_id) {
		return reservationRepository.getListReservationByBookID(book_id);
	}

	public List<Reservation> setPositionOfReservation(Long book_id) {
		List<Reservation> list = reservationRepository.getListReservationByBookID(book_id);

		if (list.size() > 0) {
			int index = 1;
			for (Reservation reservation : list) {
				reservation.setPosition(index++);
			}
			list = reservationRepository.saveAll(list);
		}
		return list;		
	}

	@Override
	public List<Reservation> getListReservationByUser(Long user_id) {
		return reservationRepository.getListReservationByUserID(user_id);
	}

	@Override
	@Transactional
	public void checkReservation(Book book) throws BibliothequeException {

		// si il y a une liste de réservation pour ce livre
		if (getListReservationByBook(book.getId()).size() != 0) {

			Reservation reservation = getListReservationByBook(book.getId()).get(0);
			Mail mail = mailBusiness.getMailByUserID(reservation.getUser().getId());

			// on ajoute une date limite de récupération
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.HOUR, resetReservationToHour);
			reservation.setEndReservation(calendar.getTime());
			reservationRepository.save(reservation);

			String body = MessageFormat.format(bodyRecovery, book.getTitle());
			String[] tableau_email = { mail.getEmail() };
			// on envoie un email pour prévenir de la disponnibilité du livre
			// sendMail.sendFromGMail(emailUsers, jasypt.getDecrypt(emailPassword),
			// tableau_email, objectRecovery, body);
			logger.info("Send Email for reservation " + reservation.getId());

		} else {
			// on incrémente le nombre de copie disponnible
			book.setCopyAvailable(book.getCopyAvailable() + 1);
			if (!book.isAvailable()) {
				book.setAvailable(true);
				book.setAvailableReservation(false);
			}
			bookRepository.save(book);
		}

	}

	public List<Reservation> getListReservationWithEndDate() {
		return reservationRepository.getListReservationWithEndDate();
	}

}
