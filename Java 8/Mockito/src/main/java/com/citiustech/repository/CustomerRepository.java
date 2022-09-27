package com.citiustech.repository;

import java.util.ArrayList;
import java.util.List;

import com.citiustech.entity.Customer;

// assumption we are using jdbc or hibernate

public class CustomerRepository {
	private List<Customer> customers;
	
	
	public CustomerRepository() {
		
		customers=new ArrayList<Customer>();
		customers.add(new Customer(111, "Kevin", "amol.asutkar@gmail.com"));
		customers.add(new Customer(222, "asutkar", "asutkar.@gmail.com"));
		customers.add(new Customer(333, "ajya", "ajya.@gmail.com"));

				
	}
	
	public boolean isCustomerPresent(String email) {
		
		 return customers
				 .stream()
				 .anyMatch(c -> c.getEmail().equals(email));
		 
		
	}
	
	// it is original method and it will throw exception only if name is null,not always
	// but mock that is duplicate method will always throw an exception
	public int saveCustomer(Customer customer) {
		
		if(customer.getName()==null)
			throw new RuntimeException("invalid data");
		else
		{
		customers.add(customer);
		return  customer.getId();
		}
		
		
	}
}
