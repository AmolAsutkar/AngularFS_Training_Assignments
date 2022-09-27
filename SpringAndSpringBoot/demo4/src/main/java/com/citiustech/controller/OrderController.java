package com.citiustech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.citiustech.service.OrderService;

public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/place-order")
	public void placeOrder() {
		orderService.placeOrder();
	}
}
