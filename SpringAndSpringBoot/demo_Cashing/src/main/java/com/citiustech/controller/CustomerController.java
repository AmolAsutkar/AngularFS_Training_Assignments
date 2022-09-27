package com.citiustech.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.entity.Customer;
import com.citiustech.service.CustomerService;

@RestController
@RequestMapping("/customer/*")
public class CustomerController {
	
	

		@Autowired
		private CustomerService customerService;
		
		@GetMapping("/all")
		public Iterable<Customer> getall() {
			return customerService.registeredCustomers();
		}
		

		@GetMapping("/id/{id}")
		public Customer get(@PathVariable("id") int id) {
			return customerService.customer(id);
		}
		}
