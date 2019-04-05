package com.bibliotheque.metier;

import com.bibliotheque.entities.Book;
import com.bibliotheque.exception.BibliothequeException;

public interface BookBusiness {
	public void createBook(Book Book, String kind) throws BibliothequeException;
	public void saveBook(Book Book, String kind) throws BibliothequeException;
	public void saveBook(Book Book);
	public void deleteBook(Long id);
	public Book getBook(Long id);
	public PageBook listBook(String mc, String kind, boolean available, int page, int size);
	public void validateBook(Book Book) throws BibliothequeException;
	
}
