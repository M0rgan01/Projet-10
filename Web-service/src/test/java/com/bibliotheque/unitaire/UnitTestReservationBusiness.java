package com.bibliotheque.unitaire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.bibliotheque.dao.BookRepository;
import com.bibliotheque.dao.ReservationRepository;
import com.bibliotheque.entities.Book;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Reservation;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.metier.BookBusiness;
import com.bibliotheque.metier.MailBusiness;
import com.bibliotheque.metier.ReservationBusinessImpl;
import com.bibliotheque.metier.UserBusiness;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTestReservationBusiness {

	@Mock
	private ReservationRepository reservationRepository;
	@InjectMocks
	private ReservationBusinessImpl reservationBusiness;
	@Mock
	private BookBusiness bookBusiness;
	@Mock
	private BookRepository bookRepository;
	@Mock
	private UserBusiness userBusiness;
	@Mock
	private MailBusiness mailBusiness;
	private Book book;
	private User user;
	private Mail mail;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(reservationBusiness, "resetReservationToHour", 48);
		ReflectionTestUtils.setField(reservationBusiness, "bodyRecovery", "bla");
		book = new Book();
		book.setCopyAvailable(1);
		book.setCopyTotals(1);
		book.setId(1l);
		book.setAvailable(false);
		book.setAvailableReservation(true);
		user = new User();
		user.setId(1l);	
		mail = new Mail();
		mail.setEmail("test");
	}

	
	@Test
	public void testCreateReservation() throws BibliothequeException {
		Mockito.when(userBusiness.getUser(user.getId())).thenReturn(user);
		Mockito.when(bookBusiness.getBook(book.getId())).thenReturn(book);
			
		Reservation reservation = reservationBusiness.createReservation(book.getId(), user.getId());

		assertEquals(reservation.getBook().getNumberReservation(), 1);		
		assertTrue(reservation.getBook().isAvailableReservation());
	
		Reservation reservation2 = reservationBusiness.createReservation(book.getId(), user.getId());

		assertEquals(reservation2.getBook().getNumberReservation(), 2);		
		assertTrue(!reservation2.getBook().isAvailableReservation());
	}
	
	
	@Test(expected = BibliothequeException.class)
	public void testCreateReservationWithReservationAlreadyExistForUser() throws BibliothequeException {
		//on simule qu'un utilisateur à déjà une réservation pour ce livre
		Mockito.when(reservationRepository.findByUserIdAndBookId(book.getId(), user.getId())).thenReturn(new Reservation());
		reservationBusiness.createReservation(book.getId(), user.getId());
	}
	
	@Test(expected = BibliothequeException.class)
	public void testCreateReservationWithBookNoAvailableReservation() throws BibliothequeException {
		book.setAvailableReservation(false);
		Mockito.when(bookBusiness.getBook(book.getId())).thenReturn(book);
		reservationBusiness.createReservation(book.getId(), user.getId());
	}
	
	@Test(expected = BibliothequeException.class)
	public void testCreateReservationWithBookAvailable() throws BibliothequeException {
		book.setAvailable(true);
		Mockito.when(bookBusiness.getBook(book.getId())).thenReturn(book);
		reservationBusiness.createReservation(book.getId(), user.getId());
	}
	
	@Test
	public void testDeleteReservation() throws BibliothequeException {
		book.setNumberReservation(2);
		
		Mockito.when(reservationRepository.deleteByUserIdAndBookId(book.getId(), user.getId())).thenReturn(1);
		Mockito.when(bookBusiness.getBook(book.getId())).thenReturn(book);
		Mockito.when(bookRepository.save(Mockito.any(Book.class))).thenAnswer(i -> i.getArguments()[0]);
		
		book = reservationBusiness.deleteReservation(book.getId(), user.getId());

		assertEquals(book.getNumberReservation(), 1);
	
	}
	
	@Test(expected = BibliothequeException.class)
	public void testDeleteReservationWithNoReservationExist() throws BibliothequeException {
		Mockito.when(reservationRepository.deleteByUserIdAndBookId(book.getId(), user.getId())).thenReturn(0);
		reservationBusiness.deleteReservation(book.getId(), user.getId());
	}
	
	@Test
	public void testSetPositionOfReservation() throws BibliothequeException {
		int index = 1;
		List<Reservation> list = new ArrayList<Reservation>();
		list.add(new Reservation());
		list.add(new Reservation());
		list.add(new Reservation());
		
		Mockito.when(reservationRepository.saveAll(Mockito.anyList())).thenAnswer(i -> i.getArguments()[0]);
		Mockito.when(reservationRepository.getListReservationByBookID(book.getId())).thenReturn(list);
		
		list = reservationBusiness.setPositionOfReservation(book.getId());
		
		for (Reservation reservation : list) {
			assertEquals(reservation.getPosition(), index);
			index++;	
		}
	}
	
	@Test
	public void testCheckReservationWithNoReservationForBook() throws BibliothequeException {
		book.setCopyAvailable(0);
		reservationBusiness.checkReservation(book);
		assertEquals(book.isAvailable(), true);
		assertEquals(book.isAvailableReservation(), false);
		assertEquals(book.getCopyAvailable(), 1);
	}
	
	@Test
	public void testCheckReservationWithReservationForBook() throws BibliothequeException {
		List<Reservation> list = new ArrayList<Reservation>();
		list.add(new Reservation(new Date(), user, book));
		
		Mockito.when(reservationRepository.getListReservationByBookID(book.getId())).thenReturn(list);
		Mockito.when(reservationRepository.save(Mockito.any(Reservation.class))).thenAnswer(i -> i.getArguments()[0]);		
		Mockito.when(mailBusiness.getMailByUserID(user.getId())).thenReturn(mail);
		
		reservationBusiness.checkReservation(book);		
			
		//on récupère l'object en argument de la méthode save
		ArgumentCaptor<Reservation> argument = ArgumentCaptor.forClass(Reservation.class);
		verify(reservationRepository).save(argument.capture());
		
		//on vérifie que la valeur à bien été attribué
		assertNotNull(argument.getValue().getEndReservation());
	}
	
}
