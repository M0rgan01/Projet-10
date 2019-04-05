package com.bibliotheque.metier;

import java.util.List;

import com.bibliotheque.entities.Loan;
import com.bibliotheque.exception.BibliothequeException;

public interface LoanBusiness {
	public void extendLoan(Long loanID, Long user_id) throws BibliothequeException; 
	public void deleteLoan(Long id);
	public Loan getLoan(Long id);
	public void createLoan(Long book_id, Long user_id, Loan Loan) throws BibliothequeException;
	public List<Loan> getListLoanByUserID(Long user_id);
	public List<Loan> getListLoanLateByUserID(Long user_id);
	public int getDaysExtend();
}
