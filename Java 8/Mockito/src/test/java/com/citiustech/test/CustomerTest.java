package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.citiustech.entity.Customer;
import com.citiustech.repository.CustomerRepository;
import com.citiustech.service.CustomerService;
import com.citiustech.service.CustomerService.Status;

public class CustomerTest {
	
	@Test
	public void registermethod_ShouldbeSuccessful() {
		
		CustomerRepository customerRepository = new CustomerRepository();
	//	CustomerService customerService = new CustomerService(customerRepository);
		
		Customer customer = new Customer(345, "ed", "ed@gmail.com");
		//Status status=customerService.registerCustomer(customer);
		
		//assertEquals(status,Status.SUCCESS);
	}
	
	

}
