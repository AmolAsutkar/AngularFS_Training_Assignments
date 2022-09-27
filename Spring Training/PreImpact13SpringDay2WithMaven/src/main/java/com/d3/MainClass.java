package com.d3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("com/d3/config.xml");
	Employee emp = context.getBean("emp1",Employee.class);
	System.out.println(emp);
	
	Employee emp2 = context.getBean("emp2",Employee.class);
	System.out.println(emp2);
		

	}

}

//traditional approach
//reference
//Employee obj = new Employee();
//obj.setEmployee_name("Bhushan");
//obj.setEmployee_phone("12345");
//Address add = new Address();
//add.setCity("Mumbai");
//add.setState("Maharashtra");
//add.setCountry("India");
//obj.setAddress(add);