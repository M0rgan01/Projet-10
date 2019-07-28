package com.bibliotheque.exception;

import javax.xml.ws.WebFault;

@WebFault(name = "BibliothequeException")
public class BibliothequeException extends Exception{
	
	private BibliothequeFault bibliothequeFault;

	
	public BibliothequeException(String message, BibliothequeFault bibliothequeFault) {
		super(message);
		this.bibliothequeFault = bibliothequeFault;
	}
	
	public BibliothequeException(String message, Throwable throwable, BibliothequeFault bibliothequeFault) {
		super(message, throwable);
		this.bibliothequeFault = bibliothequeFault;
	}
	
	public BibliothequeFault getInfo() {
		return bibliothequeFault;
	}
}
