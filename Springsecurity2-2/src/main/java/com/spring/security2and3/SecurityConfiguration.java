package com.spring.security2and3;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		
		auth.inMemoryAuthentication()
		.withUser("heyy")
		.password(getPasswordEncoder().encode("998876"))
		.roles("USER")
		.and()
		.withUser("oii")
		.password(getPasswordEncoder().encode("098"))
		.roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		
		return new BCryptPasswordEncoder();
	}
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
		   .antMatchers("/admin").hasRole("ADMIN")
		   .antMatchers("/user").hasAnyRole("ADMIN","USER")
		   .antMatchers("/").permitAll()
		   .and().formLogin().and().logout().deleteCookies("KJIUYRR").and().rememberMe().key("remember");
		
		
		
	}
	
}
