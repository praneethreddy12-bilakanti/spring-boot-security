package com.praneeth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@	EnableWebSecurity
@Configuration
public class SpringSecure extends WebSecurityConfigurerAdapter{

	
	@Autowired
	DataSource ds;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.jdbcAuthentication()
		.dataSource(ds);
	
	
	
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub

	http.authorizeRequests()
	.antMatchers("/admin").hasAnyRole("admin")
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
