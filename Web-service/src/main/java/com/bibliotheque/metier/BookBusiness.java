package com.bibliotheque.metier;

import com.bibliotheque.entities.Book;
import com.bibliotheque.exception.BibliothequeException;

/**
 * interface métier livre
 * 
 * @author PICHAT morgan
 *
 */
public interface BookBusiness {
	
	/**
	 * persistance d'un livre
	 * 
	 * @param book --> livre à créer
	 * @return Book
	 * 
	 * @throws BibliothequeException --> attribut title, author, description, copyTotals, kind non renseigné ou incorrect
	 */
	public Book createBook(Book book) throws BibliothequeException;
	
	/**
	 * mise à jour d'un livre
	 * 
	 * @param book --> livre à mettre à jour
	 * @param kind --> genre lié au livre
	 * @return book modifier
	 * 
	 * @throws BibliothequeException --> attribut ID, title, author, description, copyTotals, kind non renseigné ou incorrect
	 */
	public Book saveBook(Book Book) throws BibliothequeException;
	
	
	/**
	 * Rend un livre non visible dans la récupération pour la recherche ou l'emprunt
	 * 
	 * @param id --> ID du livre
	 * @throws BibliothequeException --> attribut ID incorrect ou déjà non visible
	 */
	public void deleteBook(Long id) throws BibliothequeException;
	
	/**
	 * Récupération d'un livre
	 * 
	 * @param id --> ID du livre
	 * 
	 * @return Object book
	 * @throws BibliothequeException --> attribut ID incorrect
	 */
	public Book getBook(Long id) throws BibliothequeException;
	
	/**
	 * Récupération d'une pagination de livre
	 * 
	 * @param mc --> mot clé 
	 * @param kind --> genre du livre
	 * @param available --> disponibilité du livre
	 * @param page --> page à chercher
	 * @param size --> taille de la page
	 * 
	 * @return Page de livre
	 */
	public Pagination<Book> listBook(String mc, String kind, boolean available, int page, int size);
	
	/**
	 * Validation d'un livre
	 * 
	 * @param book --> livre à valider
	 * 
	 * @throws BibliothequeException -->  attribut title, author, description, copyTotals non renseigné ou incorrect
	 */
	public void validateBook(Book Book) throws BibliothequeException;
	
}
