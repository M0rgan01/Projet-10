package com.bibliotheque.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bibliotheque.entities.Utilisateur;
import com.bibliotheque.metier.UtilisateurMetier;

@Component
@WebService
public class BibliothequeService {

	@Autowired
	private UtilisateurMetier utilisateurMetier;

	@WebMethod
	public void saveUtilisateur(@WebParam(name="utilisateur")Utilisateur utilisateur) {
		utilisateurMetier.saveUtilisateur(utilisateur);
	}
	@WebMethod
	public void deleteUtilisateur(@WebParam(name="id")Long id) {
		utilisateurMetier.deleteUtilisateur(id);
	}
	@WebMethod
	public Utilisateur getUtilisateur(@WebParam(name="id")Long id) {
		return utilisateurMetier.getUtilisateur(id);
	}
	
	
}
