package com.bibliotheque.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bibliotheque.service.BibliothequeException_Exception;
import com.bibliotheque.service.BibliothequeServiceService;
import com.bibliotheque.service.BibliothequeWS;
import com.bibliotheque.service.Roles;
import com.bibliotheque.service.Utilisateur;
import com.bibliotheque.utilities.Encrypt;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private Utilisateur utilisateur;
	private List<GrantedAuthority> grantedAuths;
	private HttpSession httpSession;
	@Autowired
	private Encrypt encrypt;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();
		httpSession = getSession();
		
		try {
			utilisateur = new Utilisateur();
			utilisateur.setPassWord(encrypt.setEncrypt(authentication.getCredentials().toString()));
			utilisateur = ws.doConnection(authentication.getName(), utilisateur.getPassWord());				
			httpSession.setAttribute("utilisateur_id", utilisateur.getId());
		} catch (BibliothequeException_Exception e) {
			throw new BadCredentialsException(e.getFaultInfo().getInfo().getFaultString());
		}

		grantedAuths = new ArrayList<>();

		for (Roles role : ws.getListRoles(utilisateur.getPseudo())) {
			grantedAuths.add(new SimpleGrantedAuthority(role.getRole()));
		}
				
		return new UsernamePasswordAuthenticationToken(utilisateur.getPseudo(), utilisateur.getPassWord(),
				grantedAuths);

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	public HttpSession getSession() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession(true); // true == allow create
	}
	
}
