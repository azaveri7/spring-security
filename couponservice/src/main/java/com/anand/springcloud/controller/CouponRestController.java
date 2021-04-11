package com.anand.springcloud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anand.springcloud.model.Coupon;
import com.anand.springcloud.repository.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
	
	@Autowired
	private CouponRepo couponRepo;
	
	@RequestMapping(value = "/coupons", method = RequestMethod.POST)
	public Coupon create(@RequestBody Coupon coupon) {
		return couponRepo.save(coupon);
	}
		
	
	@RequestMapping(value = "/coupons/{code}", method = RequestMethod.GET) 
	public Coupon getCouponByCode(@PathVariable("code") String code) { 
		return couponRepo.findByCode(code);
	}
	
	/*
	 * @RequestMapping(value = "/coupons/{id}", method = RequestMethod.GET) public
	 * Optional<Coupon> getCouponById(@PathVariable("id") String id) { return
	 * couponRepo.findById(Long.valueOf(id)); }
	 */
	

}
