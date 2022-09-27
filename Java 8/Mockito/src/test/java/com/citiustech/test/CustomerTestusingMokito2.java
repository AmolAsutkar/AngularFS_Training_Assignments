package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.citiustech.entity.Customer;
import com.citiustech.repository.CustomerRepository;
import com.citiustech.service.CustomerService;
import com.citiustech.service.CustomerService.Status;
import com.citiustech.service.EmailNotificationService;

@ExtendWith(MockitoExtension.class)
public class CustomerTestusingMokito2 {
	
	@Spy
	CustomerRepository customerRepository = new CustomerRepository();
	// for save method dont mock
	// mock only for ispresent method we have mock this method so that it will always return false
	// so new customer will always be added whether it is already present or not
	
	@Mock
	EmailNotificationService emailNotificationService;
	
	@InjectMocks
	CustomerService customerService;
	
	
	
	@Test
	public void registermethod_ShouldbeSuccessful() {
		
	
		//Mockito.when(customerRepository.isCustomerPresent(Mockito.anyString())).thenReturn(false);
		
	Mockito.doReturn(false).when(customerRepository).isCustomerPresent(Mockito.anyString());
		//Mockito.when(customerRepository.saveCustomer(Mockito.any(Customer.class))).thenReturn(45);
		Mockito.doNothing().when(emailNotificationService).sendEmail(Mockito.any(Customer.class));
		Customer customer = new Customer(333, "ajya", "ajya.@gmail.com");
		Status status=customerService.registerCustomer(customer);
		
		assertEquals(status,Status.SUCCESS);
	}
	
	
	

}
