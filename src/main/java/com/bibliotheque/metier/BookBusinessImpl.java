package com.bibliotheque.metier;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.BookRepository;
import com.bibliotheque.entities.Book;
import com.bibliotheque.entities.Kind;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;

@Service
public class BookBusinessImpl implements BookBusiness {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private KindBusiness kindBusiness;

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public Book getBook(Long id) {
		return bookRepository.findById(id).orElse(null);
	}

	@Override
	public PageBook listBook(String mc, String kind, boolean available, int page, int size) {

		Page<Book> books = null;

		if (available) {
			books = bookRepository.getListBooks("%" + mc + "%", "%" + kind + "%", available,
					PageRequest.of(page, size));
		} else {
			books = bookRepository.getListBooks("%" + mc + "%", "%" + kind + "%", PageRequest.of(page, size));
		}

		PageBook pageBook = new PageBook();
		pageBook.setBooks(books.getContent());
		pageBook.setNumberBook(books.getNumberOfElements());
		pageBook.setPage(books.getNumber());
		pageBook.setTotalsPage(books.getTotalPages());
		pageBook.setTotalsBooks((int) books.getTotalElements());

		return pageBook;
	}

	@Override
	public void createBook(Book book, String kind) throws BibliothequeException {

		Kind kind2 = new Kind(kind);
		kindBusiness.validateKind(kind2);

		book.setKind(kind2);
		book.setAvailable(true);	
		book.setCopyAvailable(book.getCopyTotals());
		
		validateBook(book);

		bookRepository.save(book);
	}

	@Override
	public void saveBook(Book book, String kind) throws BibliothequeException {

		Book book2 = bookRepository.findById(book.getId()).orElse(null);

		if (book2 == null) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("11");
			bibliothequeFault.setFaultString("Aucun ouvrage correspondant");
			throw new BibliothequeException("Aucun ouvrage correspondant", bibliothequeFault);

		} else if (book.getCopyTotals() != book2.getCopyTotals()) {

			int a = book.getCopyTotals() - book2.getCopyTotals();
			
			book.setCopyAvailable(book.getCopyAvailable() + a);
			
			if (book.getCopyAvailable() < 0)
				book.setCopyAvailable(0);

			if (book.getCopyAvailable() == 0)
				book.setAvailable(false);
			
		}

		Kind kind2 = new Kind(kind);
		kindBusiness.validateKind(kind2);
		book.setKind(kind2);
		validateBook(book);

		bookRepository.save(book);

	}

	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	public void validateBook(Book book) throws BibliothequeException {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Book>> violations2 = validator.validate(book);

		for (ConstraintViolation<Book> violation : violations2) {

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultString(violation.getMessage());

			throw new BibliothequeException(violation.getMessage(), bibliothequeFault);
		}
	}

}
