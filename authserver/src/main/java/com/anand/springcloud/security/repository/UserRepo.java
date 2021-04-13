package com.anand.springcloud.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.springcloud.security.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
