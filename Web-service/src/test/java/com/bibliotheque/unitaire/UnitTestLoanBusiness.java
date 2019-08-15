package com.bibliotheque.unitaire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.bibliotheque.dao.BookRepository;
import com.bibliotheque.dao.LoanRepository;
import com.bibliotheque.entities.Book;
import com.bibliotheque.entities.Loan;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.metier.LoanBusinessImpl;
import com.bibliotheque.metier.ReservationBusiness;
import com.bibliotheque.metier.UserBusiness;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTestLoanBusiness {

	@Mock
	private LoanRepository loanRepository;
	@InjectMocks
	private LoanBusinessImpl loanBusiness;
	@Mock
	private UserBusiness userBusiness;
	@Mock
	private ReservationBusiness reservationBusiness;
	@Mock
	private BookRepository bookRepository;

	private Loan loan;
	private Book book;
	private User user;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(loanBusiness, "loanDays", 48);
		ReflectionTestUtils.setField(loanBusiness, "extendDays", 48);
		book = new Book();
		book.setCopyAvailable(1);
		book.setId(1l);
		book.setAvailable(true);
		book.setAvailableReservation(false);
		user = new User();
		user.setId(1l);	
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, loanBusiness.getDaysLoan());
		loan = new Loan(new Date(), c.getTime(), user, book);
		loan.setId(1l);	
	}

	@Test
	public void testCreateLoan() throws BibliothequeException {

		Mockito.when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
		Mockito.when(userBusiness.getUser(user.getId())).thenReturn(user);
		Mockito.when(loanRepository.save(Mockito.any(Loan.class))).thenAnswer(i -> i.getArguments()[0]);

		loan = loanBusiness.createLoan(book.getId(), user.getId());

		// vérification de la disponnibilité du livre après emprunt
		assertEquals(loan.getBook().isAvailable(), false);
		assertEquals(loan.getBook().isAvailableReservation(), true);

		// vérification de la date de fin
		String pattern = "MM/dd/yyyy";
		DateFormat df = new SimpleDateFormat(pattern);
		String endDate = df.format(loan.getEnd_loan());

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, loanBusiness.getDaysLoan());
		String endDateToCompare = df.format(c.getTime());

		// on vérifie que la date de fin est bien correct
		assertEquals(endDate, endDateToCompare);

	}

	@Test(expected = BibliothequeException.class)
	public void testCreateLoanWithBadBookId() throws BibliothequeException {
		Mockito.when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
		loanBusiness.createLoan(50l, user.getId());
	}

	@Test(expected = BibliothequeException.class)
	public void testCreateLoanWithBookDisable() throws BibliothequeException {
		book.setDisable(true);
		Mockito.when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
		loanBusiness.createLoan(book.getId(), user.getId());
	}

	@Test(expected = BibliothequeException.class)
	public void testCreateLoanWithNoCopyAvailable() throws BibliothequeException {
		book.setCopyAvailable(0);
		Mockito.when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
		loanBusiness.createLoan(book.getId(), user.getId());
	}

	@Test
	public void testExtendLoan() throws BibliothequeException {		
		loan.getBook().setAvailable(false);
		List<Loan> list = new ArrayList<Loan>();
		list.add(loan);
		
		Mockito.when(loanRepository.save(Mockito.any(Loan.class))).thenAnswer(i -> i.getArguments()[0]);
		Mockito.when(loanRepository.findById(loan.getId())).thenReturn(Optional.of(loan));		
		Mockito.when(loanRepository.getListLoanByBookAndOrderByEndLoan(book.getId())).thenReturn(list);
		
		loan = loanBusiness.extendLoan(loan.getId(), user.getId());

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

	}

	@Test(expected = BibliothequeException.class)
	public void testExtendLoanAlreadyExtend() throws BibliothequeException {

		loan.setExtension(true);
		Mockito.when(loanRepository.findById(loan.getId())).thenReturn(Optional.of(loan));
		loanBusiness.extendLoan(loan.getId(), user.getId());
	}
	
	@Test(expected = BibliothequeException.class)
	public void testExtendLoanWithBadId() throws BibliothequeException {
		Mockito.when(loanRepository.findById(loan.getId())).thenReturn(Optional.of(loan));
		loanBusiness.extendLoan(50l, user.getId());
	}
	
	@Test(expected = BibliothequeException.class)
	public void testExtendLoanWithBadUser() throws BibliothequeException {
		Mockito.when(loanRepository.findById(loan.getId())).thenReturn(Optional.of(loan));
		loanBusiness.extendLoan(loan.getId(), 50l);
	}
	
	@Test(expected = BibliothequeException.class)
	public void testExtendLoanWithLate() throws BibliothequeException {

		// on simule un retard de date
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		loan.setEnd_loan(c.getTime());

		Mockito.when(loanRepository.findById(loan.getId())).thenReturn(Optional.of(loan));

		loanBusiness.extendLoan(loan.getId(), user.getId());
	}
	
	@Test
	public void testReturnLoan() throws BibliothequeException {
		
		Mockito.when(loanRepository.findById(loan.getId())).thenReturn(Optional.of(loan));
		Mockito.when(loanRepository.save(Mockito.any(Loan.class))).thenAnswer(i -> i.getArguments()[0]);
		
		loan = loanBusiness.returnLoan(loan.getId());
		// on vérifie que l'emprunt à bien le statut rendu
		assertEquals(loan.isMade(), true);

	}

	
}
