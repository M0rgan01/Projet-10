package com.bibliotheque.unitaire;

import static org.junit.Assert.assertEquals;

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

import com.bibliotheque.dao.BookRepository;
import com.bibliotheque.entities.Book;
import com.bibliotheque.entities.Kind;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.metier.BookBusinessImpl;
import com.bibliotheque.metier.KindBusiness;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTestBookBusiness {

	@Mock
	private BookRepository bookRepository;
	@InjectMocks
	private BookBusinessImpl bookBusiness;
	@Mock
	private KindBusiness kindBusiness;
	private Book book;
	private Kind kind;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		kind = new Kind("TestKind");
		book = new Book();
		book.setKind(kind);
		book.setTitle("TestTitle");
		book.setAuthor("TestAuthor");
		book.setDescription("TestDescription");
		book.setCopyTotals(5);
		book.setId(1l);
	}

	@Test
	public void testCreateBook() throws BibliothequeException {
		Mockito.when(bookRepository.save(book)).thenReturn(book);
		book = bookBusiness.createBook(book);
		// on vérifie que le livre est bien disponnible à l'emprunt
		assertEquals(book.isAvailable(), true);
		// la disponnibilité à la réservation doit être sur false à la création
		assertEquals(book.isAvailableReservation(), false);
		assertEquals(book.getCopyTotals(), book.getCopyAvailable());
	}

	@Test
	public void testDeleteBook() throws BibliothequeException {
		Mockito.when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
		bookBusiness.deleteBook(book.getId());
		// vérification de la désactivation
		assertEquals(book.isDisable(), true);
	}

	@Test(expected = BibliothequeException.class)
	public void testDeleteBookWithBadId() throws BibliothequeException {
		Mockito.when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
		bookBusiness.deleteBook(5l);
	}

	@Test(expected = BibliothequeException.class)
	public void testDeleteBookAlreadyDisable() throws BibliothequeException {
		book.setDisable(true);
		Mockito.when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
		bookBusiness.deleteBook(book.getId());
	}

	@Test(expected=BibliothequeException.class)
	public void testSaveBookWithNegativeCopyAvailable() throws BibliothequeException {								
		book.setCopyAvailable(-1);	
		Mockito.when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
		bookBusiness.saveBook(book);	
	}
	
	@Test(expected=BibliothequeException.class)
	public void testValidateBookNull() throws BibliothequeException {								
		Book book2 = new Book();
		bookBusiness.validateBook(book2);
	}
	
	@Test(expected=BibliothequeException.class)
	public void testValidateBookWithNegativeCopyTotal() throws BibliothequeException {								
		book.setCopyTotals(-2);
		book.setCopyAvailable(5);
		bookBusiness.validateBook(book);
	}
	
}
