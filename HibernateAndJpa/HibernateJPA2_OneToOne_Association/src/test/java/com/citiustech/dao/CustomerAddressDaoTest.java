package com.citiustech.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.citiustech.entity.Customer;

class CustomerAddressDaoTest {

	@Test
	public void fetchAllCustomers() {

	CustomerAddressDao cdo=new CustomerAddressDao();
	List<Customer> list=cdo.findAllCustomer();
	//list.forEach(c-> System.out.println(c.getCustId()));
	list.forEach(System.out::println);
	}
	
	@Test
	public void findAllCustomersbyage() {

	CustomerAddressDao cdo=new CustomerAddressDao();
	List<Customer> list=cdo.findAllCustomeByAge(35);
	//list.forEach(c-> System.out.println(c.getCustId()));
	list.forEach(System.out::println);
	}
	
	@Test
	public void findAllCustomersbyCity() {

	CustomerAddressDao cdo=new CustomerAddressDao();
	List<Customer> list=cdo.findAllCustomeByCity("nandori");
	//list.forEach(c-> System.out.println(c.getCustId()));
	list.forEach(System.out::println);
	}

}
