package com.d4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/d4/config.xml");
		Student st= context.getBean("stud1",Student.class);
		System.out.println(st);
		
		Employee emp = context.getBean("emp1",Employee.class);
		System.out.println(emp);

	}

}
