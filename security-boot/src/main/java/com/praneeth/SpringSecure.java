package com.praneeth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@	EnableWebSecurity
public class SpringSecure extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
	
	auth.inMemoryAuthentication()
	.withUser("praneeth")
	.password("praneeth")
	.roles("admin")
	.and()
	.withUser("user")
	.password("user")
	.roles("user");
	
	
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub

	http.authorizeRequests()
	.antMatchers("/admin").hasRole("admin")
	.antMatchers("/user").hasRole("user")
	.antMatchers("/").permitAll()
	.and()
	.formLogin();
	}
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
	return NoOpPasswordEncoder.getInstance();	
	}
	
}
