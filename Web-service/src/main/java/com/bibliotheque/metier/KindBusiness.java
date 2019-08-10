package com.bibliotheque.metier;

import java.util.List;
import com.bibliotheque.entities.Kind;
import com.bibliotheque.exception.BibliothequeException;
/**
 * interface métier genre
 * 
 * @author PICHAT morgan
 *
 */
public interface KindBusiness {

	/**
	 * création / mise à jour d'un livre
	 * 
	 * @param kind --> genre à créer, ou à mettre à jour si l'id est renseigné
	 * @throws BibliothequeException 
	 * 
	 */
	public void saveKind(Kind kind) throws BibliothequeException;
	
	/**
	 * récupération d'une liste de genre
	 * 
	 * @return Liste de genre
	 */
	public List<Kind> getListKind();
	
	/**
	 * Récupération d'un genre
	 * 
	 * @param name --> nom du genre à récupérer
	 * 
	 * @return Object Kind
	 */
	public Kind getKind(String name);
	
	/**
	 * Validation d'un genre
	 * 
	 * @param kind --> genre à valider
	 * @throws BibliothequeException --> attribut name vide
	 */
	public void validateKind(Kind kind) throws BibliothequeException;
}
