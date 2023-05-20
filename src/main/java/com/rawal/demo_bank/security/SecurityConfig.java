package com.rawal.demo_bank.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/* 
  -- @EnableWebSecurity  enables web security support provided by Spring Security.
  
  -- WebSecurityConfigurerAdapter class provides methods 
	which has to overridden to implement custom security requirements.
*/

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//used to encode password before storing it in the database.
		private PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

	
	//For Authentication 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   auth.inMemoryAuthentication()
			.withUser("smith")
			.password(passwordEncoder().encode("smith123")).roles("ADMIN")
			.and()
			.withUser("tim")
			.password(passwordEncoder().encode("tim123")).roles("USER");
	}
   //	In above code,
   //	encode() method is used to encode the password.
	
	
	//For Authorization
	protected void configure(HttpSecurity http) throws Exception{
	       http
	          .authorizeRequests()
	            .anyRequest()
	            .authenticated()
	            .and()
	            .httpBasic();
	       http.csrf().disable();
	}

	
}
