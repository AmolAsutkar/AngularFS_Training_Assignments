package com.citiustech.dao;

import java.util.List;

import com.citiustech.entity.Customer;

public class CustomerAddressDao extends GenericDao{

	public List<Customer> findAllCustomer(){
		return entitymanagerfactory
				.createEntityManager()
				.createQuery("select c from Customer c")    //JPQL
				.getResultList();
	}
	
	public List<Customer> findAllCustomeByAge(int age){
		return entitymanagerfactory
				.createEntityManager()
				.createQuery("select c from Customer c where year(current_date())-year(c.dateofbirth) >= :age")    //JPQL query is independent of database
				.setParameter("age", age)
				.getResultList();
	}
	
	public List<Customer> findAllCustomeByCity(String city){
		return entitymanagerfactory
				.createEntityManager()    // warning goes away when adding Customer.class
				.createQuery("select c from Customer c inner join c.address a where a.city=:ct",Customer.class)    //JPQL query is independent of database
				.setParameter("ct", city)
				.getResultList();
	}
}
