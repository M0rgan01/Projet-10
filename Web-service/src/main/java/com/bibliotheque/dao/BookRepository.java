package com.bibliotheque.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bibliotheque.entities.Book;

/**
 * DAO livre
 * 
 * @author PICHAT morgan
 *
 */
public interface BookRepository extends JpaRepository<Book, Long>{
	
	/**
	 * requete de recherche de livres suivant plusieurs filtres
	 * 
	 * @param mc --> mot-clé
	 * @param kind --> genre
	 * @param isReserved --> disponnible ou non
	 * @param pageable --> object page
	 * 
	 * @return Page Book
	 */
	@Query("select b from Book b join b.kind k where (lower(b.title) like lower(:x) or lower(b.author) like lower(:x)) and k.name like :y and b.available = :d and b.disable = false order by b.title ")
	public Page<Book> getListBooks(@Param("x") String mc, @Param("y") String kind, @Param("d")boolean isReserved, Pageable pageable);
	
	/**
	 * requete de recherche de livres suivant plusieurs filtres
	 * 
	 * @param mc --> mot-clé
	 * @param kind  --> genre
	 * @param pageable --> object page
	 * 
	 * @return Page Book
	 */
	@Query("select b from Book b join b.kind k where (lower(b.title) like lower(:x) or lower(b.author) like lower(:x)) and k.name like :y and b.disable = false order by b.title ")
	public Page<Book> getListBooks(@Param("x") String mc, @Param("y") String kind, Pageable pageable);
	
}
