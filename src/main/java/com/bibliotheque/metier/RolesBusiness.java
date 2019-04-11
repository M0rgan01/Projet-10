package com.bibliotheque.metier;

import java.util.List;

import com.bibliotheque.entities.Roles;

/**
 * interface métier roles
 * 
 * @author pichat morgan
 *
 */
public interface RolesBusiness {

	/**
	 * récupère les roles d'un utilisateur
	 * 
	 * @param pseudo --> pseudo de l'utilisateur
	 * @return liste de role
	 */
	public List<Roles> getListRoles(String pseudo);
}
