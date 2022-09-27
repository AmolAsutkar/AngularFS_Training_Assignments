package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.citiustech.entity.Customer;
import com.citiustech.repository.CustomerRepository;
import com.citiustech.service.CustomerService;
import com.citiustech.service.CustomerService.Status;

@ExtendWith(MockitoExtension.class)
public class CustomerTestusingMokito {
	
	@Mock
	CustomerRepository customerRepository;
	
	@InjectMocks
	CustomerService customerService;
	
	@Test
	public void registermethod_ShouldbeSuccessful() {
		
		//CustomerRepository customerRepository = new CustomerRepository();
		//CustomerService customerService = new CustomerService(customerRepository);
		Mockito.when(customerRepository.isCustomerPresent(Mockito.anyString())).thenReturn(false);
		Mockito.when(customerRepository.saveCustomer(Mockito.any(Customer.class))).thenReturn(45);
		Customer customer = new Customer(333, "ajya", "ajya.@gmail.com");
		Status status=customerService.registerCustomer(customer);
		
		assertEquals(status,Status.SUCCESS);
	}
	
	@Test
	public void registermethod_ShouldbefailwithAnException() {
		
		
		Mockito.when(customerRepository.isCustomerPresent(Mockito.anyString())).thenReturn(false);
		//Mockito.when(customerRepository.saveCustomer(Mockito.any(Customer.class))).thenReturn(56);

		Mockito.when(customerRepository.saveCustomer(Mockito.any(Customer.class))).thenThrow(RuntimeException.class);
		Customer customer = new Customer(345, "ed", "ed@gmail.com");
		//Status status=customerService.registerCustomer(customer);
		
		assertThrows(RuntimeException.class, ()->customerService.registerCustomer(customer));
	}
	
	@Test
	public void registermethod_ShouldnotinvokeSaveMoreThanOnce() {
		
		Mockito.when(customerRepository.isCustomerPresent(Mockito.anyString())).thenReturn(false);
		Mockito.when(customerRepository.saveCustomer(Mockito.any(Customer.class))).thenThrow(RuntimeException.class);
		Customer customer = new Customer(345, "ed", "ed@gmail.com");
		Status status=customerService.registerCustomer(customer);
		
Mockito.verify(customerRepository,Mockito.times(1)).saveCustomer(Mockito.any(Customer.class));

	}
	

}
