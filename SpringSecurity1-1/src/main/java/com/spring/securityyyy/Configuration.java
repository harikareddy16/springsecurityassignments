package com.spring.securityyyy;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
public class Configuration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		PasswordEncoder encoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser("heyyy")
		.password(encoder.encode("098"))
		.roles("ADMIN");
	}
	
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
		   .antMatchers("/admin").hasRole("ADMIN")
		   .antMatchers("/").permitAll()
		   .and().formLogin();
		
	 }
	
}
