package com.bibliotheque.metier;

import java.util.Date;
import java.util.List;

import com.bibliotheque.entities.Loan;
import com.bibliotheque.exception.BibliothequeException;

/**
 * interface métier emprunt
 * 
 * @author PICHAT morgan
 *
 */
public interface LoanBusiness {
	
	/**
	 * Extention de la date de fin d'un emprunt
	 * 
	 * @param loanID --> id de l'emprunt
	 * @param user_id --> id utilisateur
	 * @throws BibliothequeException --> loanID incorrect, user_id incorrect, emprunt déjà en prolongation, retard même après prolongation
	 */
	public void extendLoan(Long loanID, Long user_id) throws BibliothequeException; 
	
	/**
	 * Rendu d'un emprunt
	 * 
	 * @param id --> id de l'emprunt
	 * @throws BibliothequeException 
	 */
	public void returnLoan(Long id) throws BibliothequeException;
	
	/**
	 * Récupération d'un emprunt
	 * 
	 * @param id --> id de l'emprunt
	 * @return emprunt
	 */
	public Loan getLoan(Long id);
	
	/**
	 * Création d'un emprunt
	 * 
	 * @param book_id --> livre lié à l'emprunt
	 * @param user_id --> utilisateur lié à l'emprunt
	 * @throws BibliothequeException--> book_id incorrect, user_id incorrect, ouvrage non disponible
	 */
	public void createLoan(Long book_id, Long user_id) throws BibliothequeException;
	
	/**
	 * Récupération des emprunts actuel sans retard d'un utilisateur 
	 * 
	 * @param user_id --> id utilisateur
	 * @return liste d'emprunt
	 */
	public List<Loan> getListLoanByUserID(Long user_id);
	
	/**
	 * Récupération des emprunts actuel en retard d'un utilisateur 
	 * 
	 * @param user_id --> id utilisateur
	 * @return liste d'emprunt
	 */
	public List<Loan> getListLoanLateByUserID(Long user_id);
	
	/**
	 * Récupération des emprunts actuel en retard 
	 * 
	 * @return liste d'emprunt
	 */
	public List<Loan> getListLoanLate();
		
	/**
	 * @return Nombre de jour pour l'extention d'un emprunt
	 */
	public int getDaysExtend();
	
	/**
	 * @return Nombre de jour d'un emprunt
	 */
	public int getDaysLoan();
	
	public Date setLoanBackForBook(Long book_id);
	
}
