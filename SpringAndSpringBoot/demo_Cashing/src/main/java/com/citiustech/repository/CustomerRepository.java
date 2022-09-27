package com.citiustech.repository;

import java.util.List;


import com.citiustech.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	
	

}