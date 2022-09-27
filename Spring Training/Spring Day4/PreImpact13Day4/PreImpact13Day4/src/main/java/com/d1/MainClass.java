package com.d1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/d1/config.xml");
		EmpRepoImpl emp =  context.getBean("empRepoImpl", EmpRepoImpl.class);
		EmpRepoImpl emp2 =  context.getBean("empRepoImpl", EmpRepoImpl.class);
		
		System.out.println(emp.hashCode());
		System.out.println(emp2.hashCode());
		
		
//		emp.insertEmployee(new Employee(1,"Simon"));
//		emp.insertEmployee(new Employee(2,"Eric"));
//		
//		System.out.println("Data Inserted successfully");
//		
//		Employee empDetail = emp.getEmployeeById(2);
//		System.out.println(empDetail);
//		
//		Employee deletedEmployee = emp.deleteEmployee(1);
//		System.out.println("Employee "+deletedEmployee+" Deleted");

	}

}
