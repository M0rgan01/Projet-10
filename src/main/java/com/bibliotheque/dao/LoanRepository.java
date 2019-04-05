package com.bibliotheque.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bibliotheque.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{

	@Query("select count(l.id) from Loan l where not (l.start > :d or l.end < :f)")
	public int getContLoan(@Param("d") Date start, @Param("f") Date end);
	
	//recupere list des reservations en cours pour un utilisateur
	@Query("select l from Loan l where l.user.id = :x and l.end > :y and made = false")
	public List<Loan> getListLoanByUserID(@Param("x")Long user_id, @Param("y")Date now);
	
	//recupere list des reservations en retard pour un utilisateur
	@Query("select l from Loan l where l.user.id = :x and l.end < :y and made = false")
	public List<Loan> getListLoanLateByUserID(@Param("x")Long user_id, @Param("y")Date now);
}
