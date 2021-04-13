package com.anand.springcloud.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.springcloud.security.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{
	
}
