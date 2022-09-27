package com.citiustech.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citiustech.entity.Customer;
import com.citiustech.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	
	

		@Autowired
		private CustomerRepository customerRepository;
		
		@CacheEvict("customers.cache")
		public void register(Customer customer) {
			customerRepository.save(customer);
		}
		
		@Cacheable(value="customer.cache",key="#id")//, condition="#id > 1111")
		public Customer customer(int id) {
			return customerRepository.findById(id).get();
		}
		
		@Cacheable("customers.cache")
		public Iterable<Customer> registeredCustomers() {
			return customerRepository.findAll();
		}

}
