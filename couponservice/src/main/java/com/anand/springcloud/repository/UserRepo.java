package com.anand.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.springcloud.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
