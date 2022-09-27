package com.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
		       .withUser("alex").password(passwordEncoder.encode("alex@123")).roles("USER")
		       .and()
		       .withUser("anna").password(passwordEncoder.encode("anna@123")).roles("ADMIN")
		       .and()
		       .passwordEncoder(passwordEncoder);
	}

	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeRequests()
		      .antMatchers("/api/v1/admin/**")
		      .hasRole("ADMIN")
		      .antMatchers("/api/v1/user/**")
		      .hasAnyRole("ADMIN", "USER")
		      .anyRequest()
		      .permitAll()
		      .and()
		      .csrf().disable(); 
	}
	
	
}
