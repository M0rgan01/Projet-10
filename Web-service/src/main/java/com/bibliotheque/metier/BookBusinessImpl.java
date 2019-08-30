package com.bibliotheque.metier;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.BookRepository;
import com.bibliotheque.entities.Book;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;

@Service
public class BookBusinessImpl implements BookBusiness {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private KindBusiness kindBusiness;
			
	private static final Logger logger = LoggerFactory.getLogger(BookBusinessImpl.class);
	
	@Override
	public void deleteBook(Long id) throws BibliothequeException {
		Book book = bookRepository.findById(id).orElse(null);

		// vérification
		if (book == null) {
			logger.error("id book "+ id + " not correct");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("1");
			bibliothequeFault.setFaultString("book.id.not.correct");
			throw new BibliothequeException("book.id.not.correct", bibliothequeFault);

		} else if (book.isDisable()) {
			logger.error("book" + book.getId() + "already disable");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("2");
			bibliothequeFault.setFaultString("book.already.disable");
			throw new BibliothequeException("book.already.disable", bibliothequeFault);
		}
		//on désactive le livre
		book.setDisable(true);
		bookRepository.save(book);
		logger.info("Success set disable to book" + book.getId() );
	}

	@Override
	public Book getBook(Long id) throws BibliothequeException {
		Book book = bookRepository.findById(id).orElse(null);

		if (book == null) {
			logger.error("id book "+ id + " not correct");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("1");
			bibliothequeFault.setFaultString("book.id.not.correct");
			throw new BibliothequeException("book.id.not.correct", bibliothequeFault);
		}
		logger.info("Success get book " + book.getId());
		return book;
	}

	@Override
	public Pagination<Book> listBook(String mc, String kind, boolean available, int page, int size) {

		Page<Book> books = null;

		if (available) {
			books = bookRepository.getListBooks("%" + mc + "%", "%" + kind + "%", available,
					PageRequest.of(page, size));
		} else {
			books = bookRepository.getListBooks("%" + mc + "%", "%" + kind + "%", PageRequest.of(page, size));
		}

		Pagination<Book> pageBook = new Pagination<Book>();
		pageBook.setT(books.getContent());
		pageBook.setNumberT(books.getNumberOfElements());
		pageBook.setPage(books.getNumber());
		pageBook.setTotalsPage(books.getTotalPages());
		pageBook.setTotalsT((int) books.getTotalElements());
		logger.info("Return pageBook of " + pageBook.getNumberT() + " elements");
		return pageBook;
	}

	@Override
	public Book createBook(Book book) throws BibliothequeException {
		// validation du genre et du livre
		kindBusiness.validateKind(book.getKind());
		validateBook(book);

		book.setAvailable(true);
		book.setAvailableReservation(false);
		book.setCopyAvailable(book.getCopyTotals());

		logger.info("Create book" + book.getId());
		return bookRepository.save(book);
		
	}

	@Override
	public Book saveBook(Book book) throws BibliothequeException {

		Book book2 = bookRepository.findById(book.getId()).orElse(null);
	
		if (book2 == null) {
			logger.error("id book "+ book.getId() + " not correct");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("1");
			bibliothequeFault.setFaultString("book.id.not.correct");
			throw new BibliothequeException("book.id.not.correct", bibliothequeFault);
			
		} 
		
		//validation du genre et du livre
		kindBusiness.validateKind(book.getKind());
		validateBook(book);
				
		logger.info("update book " + book.getId());
		return bookRepository.save(book);
	}

	public void validateBook(Book book) throws BibliothequeException {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Book>> violations2 = validator.validate(book);

		for (ConstraintViolation<Book> violation : violations2) {
			logger.error("Book " + violation.getPropertyPath() + " incorrect : " + violation.getMessage());
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultString(violation.getMessage());

			throw new BibliothequeException(violation.getMessage(), bibliothequeFault);
		}
	}

}
