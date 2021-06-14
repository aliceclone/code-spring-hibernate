package com.spring.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // get dataSoruce bean from configuration
    @Autowired
    private DataSource comboPooledDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	// use mysql-jdbc
	auth.jdbcAuthentication().dataSource(comboPooledDataSource);
    }

    // ❗"/auth" will handle by Spring, no controller + jsp need
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
		// permit css, image etc. files
		.antMatchers("/resources/**").permitAll()
		// "/**" must be authorized
		// .anyRequest().authenticated()
		// all can access INDEX page
		.antMatchers("/").permitAll()
		// permit to EMPLOYEE ROLE
		.antMatchers("/home/**").hasRole("EMPLOYEE")
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
		.logout().
		// after logout redirect to ROOT (default: /login?logout)
		logoutSuccessUrl("/").permitAll()
		//
		.and()
		// custom page for access denied
		.exceptionHandling().accessDeniedPage("/access-denied");
    }

}
