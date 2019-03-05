package com.bibliotheque.metier;

import com.bibliotheque.entities.Utilisateur;

public interface UtilisateurMetier {
	public void saveUtilisateur(Utilisateur utilisateur);
	public void deleteUtilisateur(Long id);
	public Utilisateur getUtilisateur(Long id);
}
