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
	http.authorizeRequests()
		// permit css, image etc. files
		.antMatchers("/resources/**").permitAll()
		// "/**" must be authorized
		// .anyRequest().authenticated()
		// permit to EMPLOYEE ROLE
		.antMatchers("/").hasAnyRole("EMPLOYEE")
		// permit to MANAGER ROLE
		.antMatchers("/managers/**").hasRole("MANAGER")
		// permit to SYSTEM ROLE
		.antMatchers("/systems/**").hasRole("ADMIN")
		//
		.and()
		// add custom login page, check authorization through "/auth"
		.formLogin().loginPage("/login").loginProcessingUrl("/auth").permitAll()
		//
		.and()
		// add logout
		.logout().permitAll()
		//
		.and()
		// custom page for access denied
		.exceptionHandling().accessDeniedPage("/access-denied");
    }

}
