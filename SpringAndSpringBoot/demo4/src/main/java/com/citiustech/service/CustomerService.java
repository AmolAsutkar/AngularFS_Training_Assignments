package com.citiustech.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citiustech.entity.Customer;
import com.citiustech.exception.CustomerServiceException;
import com.citiustech.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository 	customerrepository;
	
    @Transactional
	public int register(Customer customer) {
    	
    	if(customerrepository.isCustomerPresent(customer.getEmail()))
    		throw new CustomerServiceException("customer already exists with this email");
    	
    		else{
    			Customer updatedcustomer=(Customer) customerrepository.save(customer);
    			   return updatedcustomer.getCustId();

    		}
    }

    public List<Customer> fetchAll(){
    	return customerrepository.fetchAll();
    }
    
   // public List<Customer> fetchOneCustomer(int id){
    //	return customerrepository.fetchSingleCustomer(id);
   // }
    
    public Customer fetchOneCustomer(int id){
        	return customerrepository.findById(Customer.class, id);
        }

}
