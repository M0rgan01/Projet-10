package com.bibliotheque.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bibliotheque.dao.BookRepository;
import com.bibliotheque.dao.KindRepository;
import com.bibliotheque.dao.ReservationRepository;
import com.bibliotheque.dao.UserRepository;
import com.bibliotheque.entities.Book;
import com.bibliotheque.entities.Kind;
import com.bibliotheque.entities.Reservation;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.metier.ReservationBusiness;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestReservationBusiness {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private ReservationBusiness reservationBusiness;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private KindRepository kindRepository;

	private Book book;
	private User user;
	private User user2;

	@Before
	public void initContext() {
		Kind kind = kindRepository.save(new Kind("test"));
		book = new Book("test1", "test1", "test1", true, kind, 1, 1);
		book.setAvailableReservation(true);
		book = bookRepository.save(book);
		user = userRepository.save(new User("user123", "User123", true));
		user2 = userRepository.save(new User("user123", "User123", true));
	}

	@Test
	public void testCreateReservation() throws BibliothequeException {
		Reservation reservation = reservationBusiness.createReservation(book.getId(), user.getId());

		assertEquals(reservation.getBook().getNumberReservation(), 1);
		assertEquals(reservation.getPosition(), 1);
		assertTrue(reservation.getBook().isAvailableReservation());

		Reservation reservation2 = reservationBusiness.createReservation(book.getId(), user2.getId());

		assertEquals(reservation2.getBook().getNumberReservation(), 2);
		assertEquals(reservation2.getPosition(), 2);
		assertTrue(!reservation2.getBook().isAvailableReservation());
	}

	@Test(expected = BibliothequeException.class)
	public void testCreateReservationWithReservationAlreadyExistForUser() throws BibliothequeException {
		reservationBusiness.createReservation(book.getId(), user.getId());
		reservationBusiness.createReservation(book.getId(), user.getId());
	}

	@Test(expected = BibliothequeException.class)
	public void testCreateReservationWithBookNoAvailableReservation() throws BibliothequeException {
		book.setAvailableReservation(false);
		bookRepository.save(book);
		reservationBusiness.createReservation(book.getId(), user.getId());
	}

	@Test
	public void testDeleteReservation() throws BibliothequeException {
		reservationBusiness.createReservation(book.getId(), user.getId());
		Reservation r1 = reservationBusiness.createReservation(book.getId(), user2.getId());

		book = reservationBusiness.deleteReservation(book.getId(), user.getId());

		assertEquals(book.getNumberReservation(), 1);

		r1 = reservationRepository.getOne(r1.getId());

		// vérification du réajustement de la posotion
		assertEquals(r1.getPosition(), 1);
	}
	
	@Test(expected = BibliothequeException.class)
	public void testDeleteReservationWithBadBookId() throws BibliothequeException {
		reservationBusiness.deleteReservation(50l, user.getId());
	}
	
	@Test(expected = BibliothequeException.class)
	public void testDeleteReservationWithBadUserId() throws BibliothequeException {
		reservationBusiness.deleteReservation(book.getId(), 55l);
	}
	
	@Test(expected = BibliothequeException.class)
	public void testDeleteReservationWithBadId() throws BibliothequeException {
		reservationBusiness.deleteReservation(book.getId(), user.getId());
	}
}
