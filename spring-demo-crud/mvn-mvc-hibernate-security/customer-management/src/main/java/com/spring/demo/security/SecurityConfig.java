package com.spring.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // crmDataSource
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected UserDetailsService userDetailsService() {
	// TODO Auto-generated method stub
	return super.userDetailsService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
		// allow resources
		.antMatchers("/resources/**").permitAll()
		// allow index page
		.antMatchers("/").permitAll().and()
		// add custom login page
		.formLogin().loginPage("/login")
		// check authorization through "/auth"
		.loginProcessingUrl("/auth").permitAll()
		//
		.and()
		// logout
		.logout().logoutSuccessUrl("/").permitAll()
		//
		.and()
		// custom page for access denied
		.exceptionHandling().accessDeniedPage("/access-denied");
    }

}
