package com.citiustech.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("uk")
public class OrderServiceUk {
	
	public void placeOrder() {
		System.out.println("placeOrder for Uk customers..");
	}
}
