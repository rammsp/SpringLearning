package com.ram.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("ramsishu").password("rama1212").roles("User"))
		.withUser(users.username("rama1212").password("ramsishu").roles("Admin", "User"));
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").hasAnyRole("User")
		.antMatchers("/Admin/**").hasAnyRole("Admin").and()
		.formLogin().loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateUser")
		.permitAll().and()
		.logout().permitAll().and()
		.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
}
