package com.bibliotheque.metier;

import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Utilisateur;
import com.bibliotheque.exception.BibliothequeException;

public interface UtilisateurMetier {
	public Utilisateur saveUtilisateur(Utilisateur utilisateur);
	public void createUtilisateur(Utilisateur utilisateur, Mail mail) throws BibliothequeException;
	public void deleteUtilisateur(Long id);
	public Utilisateur doConnection(String pseudo, String passWord) throws BibliothequeException;
	public void checkPseudoExist(String pseudo) throws BibliothequeException;
}
