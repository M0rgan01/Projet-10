package com.bibliotheque.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bibliotheque.service.Utilisateur;

public class UserService implements UserDetails{

	private Utilisateur utilisateur;
	private List<GrantedAuthority> grantedAuths;
	
	public UserService(Utilisateur utilisateur, List<GrantedAuthority> grantedAuths) {
		super();
		this.utilisateur = utilisateur;
		this.grantedAuths = grantedAuths;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {		
		return grantedAuths;
	}

	@Override
	public String getPassword() {		
		return utilisateur.getPassWord();
	}

	@Override
	public String getUsername() {		
		return utilisateur.getPseudo();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
