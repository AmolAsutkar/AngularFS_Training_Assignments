package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class UserController {
	
	
	private static final String user-service="userservice";
	@Autowired
	RestTemplate restTemplate;
	
	
	
	@RequestMapping("/getOrders")
	@CircuitBreaker(name="userservice",fallbackMethod = "restCallForOrderService")
	
	public ResponseEntity<String> addUser()
	{
		String str=restTemplate.getForObject("http://localhost:8282/payment/doPayment", String.class);
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	
	
	
	
	

	public ResponseEntity<String> restCallForOrderService()
	{
		return new ResponseEntity<String>("User is giving rest call to Order but Order service not available",HttpStatus.OK);
	}
}
