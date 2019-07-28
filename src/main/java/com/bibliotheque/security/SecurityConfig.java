package com.bibliotheque.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Configuration de spring security
 * 
 * 
 * @author pichat morgan
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationProvider authProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(authProvider);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// formulaire de connection personnalise
		http.formLogin().loginPage("/login");

		http.authorizeRequests()
				.antMatchers("/index", "/recherche", "/politiqueConfidentialite", "/conditionUtilisation",
						"/inscription", "/saveInscription", "/recuperation", "/sendToken", "/validateToken",
						"/editPassword")
				.permitAll();

		http.authorizeRequests().antMatchers("/reservationCompte", "/prolongerReservation", "/saveProlongerReservation",
				"/modificationCompte", "/saveModificationCompte", "/suppressionCompte", "/suppressionCompteConfirm")
				.hasRole("USER");

		http.authorizeRequests().antMatchers("/ajout", "/saveAjout", "/confirmationAjout", "/modificationOuvrage",
				"/saveModificationOuvrage", "/deleteOuvrage").hasRole("ADMIN");

		// pour la deconnexion
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).clearAuthentication(true)
				.deleteCookies("JSESSIONID");

		// liens vers la page d'exception personnaliser
		//http.exceptionHandling().accessDeniedPage("/403");
	}

}
