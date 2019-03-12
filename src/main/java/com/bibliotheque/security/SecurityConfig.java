package com.bibliotheque.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private CustomAuthenticationProvider authProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN", "USER");
		//auth.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER");
		
		auth.authenticationProvider(authProvider);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// formulaire de connection personnalise
		http.formLogin().loginPage("/login");
			
		//http.authorizeRequests().antMatchers("/index").permitAll();

		http.authorizeRequests().antMatchers("/index").hasRole("USER");
		
		// pour la deconnexion
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).clearAuthentication(true)
				.deleteCookies("JSESSIONID");
	}

}
