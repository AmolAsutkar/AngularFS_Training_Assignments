package com.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("Alex").password(passwordEncoder.encode("alex123")).roles("USER")
		.and()
		.withUser("anna").password(passwordEncoder.encode("anna123")).roles("ADMIN")
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
