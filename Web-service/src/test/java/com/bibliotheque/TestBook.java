package com.bibliotheque;

import java.util.List;

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
public class TestBook {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookBusiness bookBusiness;
	@Autowired
	private KindRepository kindRepository;
	private Book book;

	@Before
	public void initObjects() {
		Kind kind = new Kind("TestKind");
		kindRepository.save(kind);

		book = new Book();
		book.setTitle("TestTitle");
		book.setAuthor("TestAuthor");
		book.setDescription("TestDescription");
		book.setCopyTotals(5);
		book.setCopyTotals(1);
		book.setKind(kind);
	}

	@Test
	public void testInsertBook() throws BibliothequeException {

		bookBusiness.createBook(book);

		List<Book> list = bookRepository.findAll();
		for (Book book2 : list) {
			System.out.println(book2.getAuthor());
		}
	}

}
