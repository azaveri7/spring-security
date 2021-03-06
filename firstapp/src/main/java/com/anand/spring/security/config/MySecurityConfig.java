package com.anand.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.anand.spring.security.filter.MySecurityFilter;
import com.anand.spring.security.provider.MyAuthenticationProvider;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MyAuthenticationProvider authProvider;
	
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
		//password will be encrypted when stored in memory passwordEncoder.encode()
		UserDetails user = User.withUsername("anand")
				.password(passwordEncoder.encode("zaveri"))
				.authorities("read").build();
		userDetailsService.createUser(user);
		//auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		auth.userDetailsService(userDetailsService);
	}
	*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(authProvider);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.httpBasic();
		//http.formLogin();
		// to permit all requests
		//http.authorizeRequests().anyRequest().permitAll();
		//http.authorizeRequests().anyRequest().authenticated();
		/*http.authorizeRequests().antMatchers("/hello")
			.authenticated().anyRequest().denyAll();*/
		http.authorizeRequests()
			.antMatchers("/hello")
			.authenticated();
		http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
