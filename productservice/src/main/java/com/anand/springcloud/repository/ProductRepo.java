package com.anand.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
