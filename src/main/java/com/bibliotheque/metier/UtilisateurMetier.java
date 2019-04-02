package com.bibliotheque.metier;

import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Utilisateur;
import com.bibliotheque.exception.BibliothequeException;

public interface UtilisateurMetier {
	
	public void validateUtilisateur(Utilisateur utilisateur) throws BibliothequeException;
	public void validatePassWord(Utilisateur utilisateur) throws BibliothequeException;
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) throws BibliothequeException;
	public Utilisateur createUtilisateur(Utilisateur utilisateur, Mail mail) throws BibliothequeException;
	public void deleteUtilisateur(Long id);
	public Utilisateur doConnection(String pseudo, String passWord) throws BibliothequeException;
	public void checkPseudoExist(String pseudo) throws BibliothequeException;
	public Utilisateur getUtilisateur(Long id);
}
