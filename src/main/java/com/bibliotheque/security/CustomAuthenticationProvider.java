package com.bibliotheque.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		//recup des info de l'utilisateur
		 String name = authentication.getName();
	     String password = authentication.getCredentials().toString();
	     
	     //test des conditions
	     if (name.equals("admin") && password.equals("1234")) {
	    	 
	    	 List<GrantedAuthority> grantedAuths = new ArrayList<>();
	         grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
	         grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	    	 
	    	  return new UsernamePasswordAuthenticationToken(
		              name, password, grantedAuths);
		}else {	    	   
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(
				UsernamePasswordAuthenticationToken.class);
	}

}
