package com.bs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.bs.service.UserSvc;

@Configuration
public class securityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserSvc userSvc;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/insert", "/console/*", "/console", "/signUp", "/resources/**", "/signUpUser");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			csrf().disable();
		http.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/**").authenticated();
		
		http
			.formLogin()
			.loginProcessingUrl("/loginProcessing")
			.loginPage("/login")
			.failureUrl("/login?error")
			.successForwardUrl("/searchBookList");
		
		http
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/now");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userSvc).passwordEncoder(userSvc.passwordEncoder());
	}

}
