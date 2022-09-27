package com.studentmanagement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


//setter inject - property injection
public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/studentmanagement/student.xml");
		Student stud1= context.getBean("student1",Student.class);
		System.out.println(stud1);
		
		Student stud2= context.getBean("student2",Student.class);
		System.out.println(stud2);
		
		Student stud3= context.getBean("student3",Student.class);
		System.out.println(stud3);

	}

}
