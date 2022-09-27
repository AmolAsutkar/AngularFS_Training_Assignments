package com.d4;

public class Student {
	//for constructor injection
	// we won't add setters and getters
	// constructors
	
	private String student_name;

	public Student(String student_name) {
		this.student_name = student_name;
	}

	public Student() {
		
	}

	@Override
	public String toString() {
		return "student_name=" + student_name + "";
	}
	
	
	
	
	
	

}
