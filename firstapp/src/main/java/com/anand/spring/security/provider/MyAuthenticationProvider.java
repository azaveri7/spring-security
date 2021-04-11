package com.anand.spring.security.provider;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("Inside custom auth provider");
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		if(username.equals("anand") && 
				pwd.equals("zaveri"))
			return new UsernamePasswordAuthenticationToken(username, pwd, Arrays.asList());
		else
			throw new BadCredentialsException("Invalid username or pwd");		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	
	
}
