package com.citiustech.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.citiustech.entity.Employee;

public class EmployeeDao {
	
	private static EntityManagerFactory entitymanagerfactory;
	
	static{
		entitymanagerfactory=Persistence.createEntityManagerFactory("hiber.trg.day1");
		Runtime.getRuntime().addShutdownHook(new Thread(()-> entitymanagerfactory.close()));
	}
	
	public int add(Employee e) {
		EntityManager entitymanager = null;
		try {
			entitymanager = entitymanagerfactory.createEntityManager();
			EntityTransaction tx = entitymanager.getTransaction();
			tx.begin();
			entitymanager.persist(e); // persist generate insert query
			tx.commit(); // internally call flush
			//entitymanager.flush();  // data not inserted as we have not commit
			
			return e.getEmpno();
		}
		finally {
			entitymanager.close();
		}
		
		
		
		
	}
	
	public Employee fetch(int empno){
		
		EntityManager entitymanager = null;
		try {
			entitymanager = entitymanagerfactory.createEntityManager();
			Employee emp=entitymanager.find(Employee.class,empno); // fing generates select query where primary key=?
			
			return emp;
		}
		finally {
			entitymanager.close();
		}
	}
	
}
