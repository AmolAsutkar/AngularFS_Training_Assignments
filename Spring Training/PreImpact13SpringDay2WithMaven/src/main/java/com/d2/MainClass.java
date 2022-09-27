package com.d2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.citiustech.App;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/d2/config.xml");
		Employee emp = context.getBean("emp",Employee.class);
		System.out.println(emp);

	}

}
