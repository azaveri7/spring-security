package com.anand.spring.security;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@SpringBootTest
class FirstappApplicationTests {

	@Test
	void testPasswordEncoders() {
		System.out.println(new BCryptPasswordEncoder().encode("password"));
		System.out.println(new Pbkdf2PasswordEncoder().encode("password"));
		// bouncy castle provider
		System.out.println(new SCryptPasswordEncoder().encode("password"));
		
		Map<String, PasswordEncoder> pwdMap = new HashMap<>();
		pwdMap.put("bcrypt", new BCryptPasswordEncoder());
		pwdMap.put("scrypt", new SCryptPasswordEncoder());
		System.out.println(new DelegatingPasswordEncoder("bcrypt", pwdMap).encode("password"));
	}

}
