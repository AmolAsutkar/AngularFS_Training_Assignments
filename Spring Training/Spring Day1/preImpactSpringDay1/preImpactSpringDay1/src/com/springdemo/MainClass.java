package com.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springdemo/configure.xml");
		//cast 1
		Message obj = (Message)context.getBean("message");
		//way 2
//		Message obj = context.getBean("message",Message.class);
		System.out.println("Hello All"+obj.getMessage());

	}

}
