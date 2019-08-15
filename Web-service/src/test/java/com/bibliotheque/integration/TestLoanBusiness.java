package com.bibliotheque.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bibliotheque.dao.BookRepository;
import com.bibliotheque.dao.KindRepository;
import com.bibliotheque.dao.LoanRepository;
import com.bibliotheque.dao.MailRepository;
import com.bibliotheque.dao.ReservationRepository;
import com.bibliotheque.dao.UserRepository;
import com.bibliotheque.entities.Book;
import com.bibliotheque.entities.Kind;
import com.bibliotheque.entities.Loan;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Reservation;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.metier.LoanBusiness;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestLoanBusiness {

	@Autowired
	private LoanBusiness loanBusiness;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MailRepository mailRepository;
	@Autowired
	private KindRepository kindRepository;
	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	private ReservationRepository reservationRepository;

	private Book book;
	private User user;
	private Loan loan;

	@Before
	public void initContext() {
		Kind kind = kindRepository.save(new Kind("test"));
		book = bookRepository.save(new Book("test1", "test1", "test1", true, kind, 1, 1));
		user = userRepository.save(new User("user123", "User123", true));
		mailRepository.save(new Mail("test@gmail.com", user));
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, loanBusiness.getDaysLoan());

		loan = loanRepository.save(new Loan(new Date(), c.getTime(), user, book));
	}

	@Test
	public void testCreateLoan() throws BibliothequeException {
		loanBusiness.createLoan(book.getId(), user.getId());

		Loan loanCompare = loanBusiness.getLoan(loan.getId());
		// vérification ID
		assertEquals(loanCompare.getBook().getId(), book.getId());
		// vérification de la disponnibilité du livre après emprunt
		assertEquals(loanCompare.getBook().isAvailable(), false);
		assertEquals(loanCompare.getBook().isAvailableReservation(), true);

		// vérification de la date de fin
		String pattern = "MM/dd/yyyy";
		DateFormat df = new SimpleDateFormat(pattern);
		String endDate = df.format(loanCompare.getEnd_loan());

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, loanBusiness.getDaysLoan());
		String endDateToCompare = df.format(c.getTime());

		assertEquals(endDate, endDateToCompare);

	}

	@Test(expected = BibliothequeException.class)
	public void testCreateLoanWithBadBookId() throws BibliothequeException {
		loanBusiness.createLoan(50l, user.getId());
	}

	@Test(expected = BibliothequeException.class)
	public void testCreateLoanWithBookDisable() throws BibliothequeException {
		book.setDisable(true);
		bookRepository.save(book);
		loanBusiness.createLoan(book.getId(), user.getId());
	}

	@Test(expected = BibliothequeException.class)
	public void testCreateLoanWithNoCopyAvailable() throws BibliothequeException {
		book.setCopyAvailable(0);
		;
		bookRepository.save(book);
		loanBusiness.createLoan(book.getId(), user.getId());
	}

	@Test
	public void testExtendLoan() throws BibliothequeException {
		book.setAvailable(false);
		bookRepository.save(book);

		loanBusiness.extendLoan(loan.getId(), user.getId());

		loanBusiness.getListLoanByUserID(user.getId()).forEach(loan -> {
			// vérification extension
			assertEquals(loan.isExtension(), true);

			// vérification de l'ajout de l'extention
			String pattern = "MM/dd/yyyy";
			DateFormat df = new SimpleDateFormat(pattern);
			String endDate = df.format(loan.getEnd_loan());

			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, loanBusiness.getDaysLoan());
			c.add(Calendar.DATE, loanBusiness.getDaysExtend());
			String endDateToCompare = df.format(c.getTime());

			assertEquals(endDate, endDateToCompare);

			// vérification de l'ajustement de la prochaine date de retour d'un livre
			assertTrue(loan.getBook().getLoanBack() != null);
		});
	}

	@Test(expected = BibliothequeException.class)
	public void testExtendLoanAlreadyExtend() throws BibliothequeException {

		loan.setExtension(true);
		loanRepository.save(loan);

		loanBusiness.extendLoan(loan.getId(), user.getId());
	}

	@Test(expected = BibliothequeException.class)
	public void testExtendLoanWithBadId() throws BibliothequeException {

		loanBusiness.extendLoan(50l, user.getId());
	}

	@Test(expected = BibliothequeException.class)
	public void testExtendLoanWithBadUser() throws BibliothequeException {

		loanBusiness.extendLoan(loan.getId(), 50l);
	}

	@Test(expected = BibliothequeException.class)
	public void testExtendLoanWithLate() throws BibliothequeException {

		// on simule un retard de date
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		loan.setEnd_loan(c.getTime());

		loanRepository.save(loan);

		loanBusiness.extendLoan(loan.getId(), user.getId());
	}

	@Test
	public void testReturnLoan() throws BibliothequeException {

		loan.getBook().setCopyAvailable(0);
		loan.getBook().setAvailable(false);
		loan.getBook().setAvailableReservation(true);
		loanRepository.save(loan);

		loanBusiness.returnLoan(loan.getId());

		Loan loanCompare = loanBusiness.getLoan(loan.getId());
		assertEquals(loanCompare.isMade(), true);
		assertEquals(loanCompare.getBook().getCopyAvailable(), 1);
		assertEquals(loanCompare.getBook().isAvailable(), true);
		assertEquals(loanCompare.getBook().isAvailableReservation(), false);
	}

	@Test
	public void testReturnLoanWithReservation() throws BibliothequeException {

		reservationRepository.save(new Reservation(new Date(), user, book));

		loanBusiness.returnLoan(loan.getId());

		Reservation reservation = reservationRepository.findByUserIdAndBookId(book.getId(), user.getId());
		// on vérifie la présence d'une date limite de récupération
		assertTrue(reservation.getEndReservation() != null);
	}

	@Test
	public void testGetListLoanLate() throws BibliothequeException {

		User userCompare = userRepository.save(new User("user1234", "User123", true));

		Calendar c = Calendar.getInstance();

		c.add(Calendar.DATE, -5);

		loanRepository.save(new Loan(new Date(), c.getTime(), user, book));
		loanRepository.save(new Loan(new Date(), c.getTime(), user, book));
		loanRepository.save(new Loan(new Date(), c.getTime(), userCompare, book));

		loanBusiness.getListLoanLate().forEach(loan -> {
			// vérification du retard
			assertTrue(loan.getEnd_loan().before(new Date()));
		});

		loanBusiness.getListLoanLateByUserID(user.getId()).forEach(loan -> {
			// vérification de l'utilisateur
			assertEquals(loan.getUser().getId(), user.getId());
			// vérification du retard
			assertTrue(loan.getEnd_loan().before(new Date()));
		});

	}

}
