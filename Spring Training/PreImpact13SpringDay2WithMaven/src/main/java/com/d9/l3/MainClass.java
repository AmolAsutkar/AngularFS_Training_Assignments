package com.d9.l3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/d9/l3/config.xml");
		Product prod= context.getBean("prod1",Product.class);
		System.out.println(prod);
		
		
//		context.close();
		context.registerShutdownHook();
		
	}

}
