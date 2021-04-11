package com.anand.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.springcloud.model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);
	
}
