package com.d1;


//1. Create a Bean class
//2. add some fields and create setter and getters

public class Student {
	private int student_id;
	private String student_name;
	private String student_address;
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_address() {
		return student_address;
	}
	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}
	@Override
	public String toString() {
		return "student_id=" + student_id + ", student_name=" + student_name + ", student_address="
				+ student_address + "]";
	}
	
}
