package com.bibliotheque.metier;

import java.util.List;

import com.bibliotheque.entities.Roles;


public interface RolesBusiness {

	public List<Roles> getListRoles(String pseudo);
}
