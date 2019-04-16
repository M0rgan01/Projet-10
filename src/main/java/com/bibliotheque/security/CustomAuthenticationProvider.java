package com.bibliotheque.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.bibliotheque.service.User;
import com.bibliotheque.utilities.Encrypt;
import com.bibliotheque.utilities.Messages;

/**
 * Classe personnalisée de connection 
 * 
 * @author pichat morgan
 *
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	private User user;
	private List<GrantedAuthority> grantedAuths;
	private HttpSession httpSession;
	@Autowired
	private Encrypt encrypt;
	@Autowired
	private Messages messages;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();
		httpSession = getSession();
		
		try {
			
			user = new User();
			user.setPassWord(encrypt.setEncrypt(authentication.getCredentials().toString()));
			//récupération de l'utilisateur par connection
			user = ws.doConnection(authentication.getName(), user.getPassWord());			
			//ajout en session de l'id utilisateur
			httpSession.setAttribute("user_id", user.getId());
									
		} catch (BibliothequeException_Exception e) {
			
			logger.info("Echec de connection de l'utilisateur " + user.getId());
			
			throw new BadCredentialsException(messages.get(e.getMessage()));
		}

		grantedAuths = new ArrayList<>();
		//récupération des roles de l'utilisateur
		for (Roles role : ws.getListRoles(user.getPseudo())) {
			grantedAuths.add(new SimpleGrantedAuthority(role.getRole()));
		}
		
		logger.info("Connection de l'utilisateur " + user.getId());
		
		return new UsernamePasswordAuthenticationToken(user.getPseudo(), user.getPassWord(),
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
