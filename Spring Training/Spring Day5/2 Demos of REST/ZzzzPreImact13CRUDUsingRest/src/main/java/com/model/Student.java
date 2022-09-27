package com.model;

public class Student {
	
	private String fname;
	private String lname;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "Student [fname=" + fname + ", lname=" + lname + "]";
	}
	public Student(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
