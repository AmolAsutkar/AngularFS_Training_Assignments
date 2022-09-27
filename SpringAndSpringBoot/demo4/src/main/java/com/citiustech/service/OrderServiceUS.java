package com.citiustech.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("us")
public class OrderServiceUS {

	
	public void placeOrder() {
		System.out.println("placeOrder for US customers..");
	}	
}
