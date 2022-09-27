package com.d6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/d6/config.xml");
		Addition add = context.getBean("addition",Addition.class);
		add.additionResult();
	}

}
