package com.spring.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.demo.common.Constant;
import com.spring.demo.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private DataSource dataSource;

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptEncoder() {
	return new BCryptPasswordEncoder();
    }

    // ❗custom password encoder and user
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
	DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	authProvider.setUserDetailsService(userService);
	authProvider.setPasswordEncoder(bCryptEncoder());
	return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	// ❗ jdbc is NOT use
	// auth.jdbcAuthentication().dataSource(dataSource);
	auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	// more specific to less
	http.authorizeRequests()
		// allow access to everyone to index
		.antMatchers("/").permitAll()
		// deny [POST]
		// .antMatchers(HttpMethod.POST).denyAll()
		// allow resources
		.antMatchers("/static/**").permitAll()
		// allow GET REQUEST to employee & manager
		.antMatchers(HttpMethod.GET, "/users", "/users/").hasAnyAuthority(Constant.EMPLOYEE, Constant.MANAGER)
		// allow POST REQUEST to admin & manager
		.antMatchers(HttpMethod.POST, "/users").hasAnyAuthority(Constant.ADMIN, Constant.MANAGER)
		// allow [add & update] to admin & manager
		.antMatchers("/users/add", "/users/{\\d+}/update").hasAnyAuthority(Constant.ADMIN, Constant.MANAGER)
		// allow ALL to admin
		.antMatchers("/users/**").hasAuthority(Constant.ADMIN)
		// everyone require to login to access function
		.antMatchers("/*").authenticated()
		//
		.and()
		// add custom login page
		.formLogin().loginPage("/login")
		// check authorization through "/auth"
		.loginProcessingUrl("/auth").permitAll()
		// .
		.and()
		// logout redirect to ROOT
		.logout().logoutSuccessUrl("/").permitAll()
		//
		.and()
		// custom page for access denied
		.exceptionHandling().accessDeniedPage("/access-denied");
    }

}
