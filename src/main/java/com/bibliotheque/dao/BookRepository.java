package com.bibliotheque.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bibliotheque.entities.Book;


public interface BookRepository extends JpaRepository<Book, Long>{
	
	@Query("select b from Book b join b.kind k where (lower(b.title) like lower(:x) or lower(b.author) like lower(:x)) and k.name like :y and b.available = :d order by b.title ")
	public Page<Book> getListBooks(@Param("x") String mc, @Param("y") String kind, @Param("d")boolean isReserved, Pageable pageable);
	@Query("select b from Book b join b.kind k where (lower(b.title) like lower(:x) or lower(b.author) like lower(:x)) and k.name like :y order by b.title ")
	public Page<Book> getListBooks(@Param("x") String mc, @Param("y") String kind, Pageable pageable);
}
