package com.bibliotheque.metier;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bibliotheque.dao.RolesRepository;
import com.bibliotheque.entities.Roles;

@Component
public class RolesBusinessImpl implements RolesBusiness{

	@Autowired
	private RolesRepository rolesRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(RolesBusinessImpl.class);
	
	@Override
	public List<Roles> getListRoles(String pseudo) {
		logger.info("Get list of roles for username " + pseudo);			
		return rolesRepository.getListRoles(pseudo);	
	}

}
