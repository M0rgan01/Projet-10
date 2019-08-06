package com.bibliotheque;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bibliotheque.dao.BookRepository;
import com.bibliotheque.dao.KindRepository;
import com.bibliotheque.entities.Book;
import com.bibliotheque.entities.Kind;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.metier.BookBusiness;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBookBusiness {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookBusiness bookBusiness;
	@Autowired
	private KindRepository kindRepository;
	private Book book;
	private Book bookCompare;
	
	
	//mise en place d'environement de test
	@Before
	public void initObjects() {
		Kind kind = new Kind("TestKind");
		kind = kindRepository.save(kind);	
		book = new Book();
		book.setTitle("TestTitle");
		book.setAuthor("TestAuthor");
		book.setDescription("TestDescription");
		book.setCopyTotals(5);
		book.setCopyAvailable(1);
		book.setKind(kind);
		book = bookRepository.save(book);		
	}

	@Test
	public void testCreateBook() throws BibliothequeException {	
		book = bookBusiness.createBook(book);	
		bookCompare = bookBusiness.getBook(book.getId());
		assertEquals(bookCompare.getTitle(), book.getTitle());
	}

	@Test
	public void testDeleteBook() throws BibliothequeException {								
		bookBusiness.deleteBook(book.getId());
		bookCompare = bookRepository.findById(book.getId()).orElse(null);	
		assertEquals(bookCompare.isDisable(), true);
	}
	
	@Test(expected=BibliothequeException.class)
	public void testDeleteBookWithBadId() throws BibliothequeException {						
		bookBusiness.deleteBook(5l);
	}
	
	@Test(expected=BibliothequeException.class)
	public void testDeleteBookAlreadyDisable() throws BibliothequeException {	
		bookCompare = bookRepository.findById(book.getId()).orElse(null);	
		bookCompare.setDisable(true);
		bookCompare.setId(3l);
		bookRepository.save(bookCompare);	
		bookBusiness.deleteBook(bookCompare.getId());
	}
	
	@Test
	public void testGetBook() throws BibliothequeException {						
		bookCompare = bookBusiness.getBook(book.getId());
		assertEquals(bookCompare.getTitle(), book.getTitle());
	}
	
	@Test(expected=BibliothequeException.class)
	public void testGetBookWithBadId() throws BibliothequeException {						
		bookCompare = bookBusiness.getBook(50l);
	}
	
	@Test
	public void testSaveBook() throws BibliothequeException {						
		bookCompare = bookBusiness.getBook(book.getId());
		bookCompare.setAuthor("TestAuthor2");
		bookCompare.setCopyTotals(4);
		
		bookBusiness.saveBook(bookCompare);
		
		bookCompare = bookBusiness.getBook(book.getId());
		assertEquals(bookCompare.getAuthor(), "TestAuthor2");
		assertEquals(bookCompare.getCopyAvailable(), 0);
		assertEquals(bookCompare.isAvailable(), false);	
		assertEquals(bookCompare.isAvailableReservation(), true);
	}
	
}
