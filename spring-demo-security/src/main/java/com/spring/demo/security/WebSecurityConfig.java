package com.spring.demo.security;

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
	// in memory authentication
	@SuppressWarnings("deprecation")
	UserBuilder users = User.withDefaultPasswordEncoder();

	auth.inMemoryAuthentication().withUser(users.username("John").password("john123").roles("EMPLOYEE"))
		.withUser(users.username("Boss").password("boss123").roles("EMPLOYEE", "MANAGER"))
		.withUser(users.username("Mary").password("mary123").roles("EMPLOYEE", "ADMIN"));

    }

    // ❗"/auth" will handle by Spring, no controller + jsp need
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	// permit css, image etc. files
	http.authorizeRequests().antMatchers("/resources/**").permitAll()
		// "/" must be authorized
		.anyRequest().authenticated().and()
		// add custom login page, check authorization through "/auth"
		.formLogin().loginPage("/login").loginProcessingUrl("/auth").permitAll().and()
		// add logout
		.logout().permitAll();
    }

}
