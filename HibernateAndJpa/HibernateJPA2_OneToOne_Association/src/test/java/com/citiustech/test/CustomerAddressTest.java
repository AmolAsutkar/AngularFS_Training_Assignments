package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.GenericDao;
import com.citiustech.entity.Address;
import com.citiustech.entity.Customer;

class CustomerAddressTest {

	@Test
	public void addCustomer() {

	Customer c=new Customer();
c.setCustName("piyush");	
c.setEmail("amol@gmail.com");
c.setDateofbirth(LocalDate.of(1993, 10, 11));

GenericDao gdao=new GenericDao();
gdao.save(c);
	}
	
	@Test
	public void addAddress() {

		Address adr=new Address();
		adr.setCity("pune");
		adr.setPincode(4567);
		adr.setState("maha");
	

	GenericDao gdao=new GenericDao();
	gdao.save(adr);
		}
	
	@Test
	public void LinkedAddressWithCustomer() {
		GenericDao gdao=new GenericDao();
		Customer c=gdao.findById(Customer.class, 1);
		Address a=gdao.findById(Address.class, 3);
		c.setAddress(a);
		gdao.save(c);
	}
	
	@Test
	public void addCustomerAlongWithAddress() { // without cascase we cannot add data in one go in both tables
		GenericDao gdao=new GenericDao();       // after adding cascade in Customer class test case runs successsfully
		
		Customer c=new Customer();
		c.setCustName("shivani");	
		c.setEmail("m@vani.com");
		c.setDateofbirth(LocalDate.of(1975, 10, 11));
		
		Address adr=new Address();
		adr.setCity("warora");
		adr.setPincode(789);
		adr.setState("maha");
		c.setAddress(adr);
		gdao.save(c);
		
	}


}
