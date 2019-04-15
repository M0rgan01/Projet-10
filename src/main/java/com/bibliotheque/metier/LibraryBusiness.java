package com.bibliotheque.metier;

import java.util.List;

import com.bibliotheque.entities.Library;
import com.bibliotheque.exception.BibliothequeException;
/**
 * interface métier bibliotheque
 * 
 * @author PICHAT morgan
 *
 */
public interface LibraryBusiness {
	/**
	 * création / mise à jour d'une bibliotheque
	 * 
	 * @param library --> bibliotheque à créer, ou à mettre à jour si l'id est renseigné
	 * 
	 */
	public void saveLibrary(Library library);
	
	/**
	 * récupération d'une liste de bibliotheques
	 * 
	 * @return Liste de bibliotheques
	 */
	public List<Library> getListLibrary();
	
	/**
	 * Récupération d'une bibliotheque
	 * 
	 * @param id --> id de la bibliotheque à récupérer
	 * 
	 * @return Object Library
	 */
	public Library getLibrary(Long id);
	
	/**
	 * Validation d'une bibliotheque
	 * 
	 * @param library --> bibliotheque à valider
	 * @throws BibliothequeException --> attribut name vide
	 */
	public void validateLibrary(Library library) throws BibliothequeException;
}
