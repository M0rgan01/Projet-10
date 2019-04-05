package com.bibliotheque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bibliotheque.dao.RolesRepository;
import com.bibliotheque.entities.Roles;

@Component
public class RolesBusinessImpl implements RolesBusiness{

	@Autowired
	private RolesRepository rolesRepository;
	
	@Override
	public List<Roles> getListRoles(String pseudo) {
						
		return rolesRepository.getListRoles(pseudo);
	}

}
