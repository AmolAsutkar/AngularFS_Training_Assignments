package com.d1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClasss {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/d1/config.xml");
		Student st =context.getBean("student1",Student.class);
		System.out.println("--------Student 1 ---------");
		System.out.println(st.getStudent_id());
		System.out.println(st.getStudent_name());
		
		Student st2 =context.getBean("student2",Student.class);
		System.out.println("--------Student 2 ---------");
		System.out.println(st2.getStudent_id());
		System.out.println(st2.getStudent_name());
		
		Student st3 =context.getBean("student3",Student.class);
		System.out.println("--------Student 3---------");
		System.out.println(st3.getStudent_id());
		System.out.println(st3.getStudent_name());

	}

}
