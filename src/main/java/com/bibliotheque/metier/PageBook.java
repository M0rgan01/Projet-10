package com.bibliotheque.metier;

import java.io.Serializable;
import java.util.List;

import com.bibliotheque.entities.Book;

public class PageBook implements Serializable{

	private List<Book> books;
	private int page;
	private int totalsPage;
	private int numberBook;
	private int totalsBooks;
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalsPage() {
		return totalsPage;
	}
	public void setTotalsPage(int totalsPage) {
		this.totalsPage = totalsPage;
	}
	public int getNumberBook() {
		return numberBook;
	}
	public void setNumberBook(int numberBook) {
		this.numberBook = numberBook;
	}
	public int getTotalsBooks() {
		return totalsBooks;
	}
	public void setTotalsBooks(int totalsBooks) {
		this.totalsBooks = totalsBooks;
	}
	
	
	
	
}
