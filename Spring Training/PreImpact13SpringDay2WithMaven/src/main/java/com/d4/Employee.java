package com.d4;

public class Employee {
	private String employee_name;
	private String employee_phone;
	private Address address;
	public Employee(String employee_name, String employee_phone, Address address) {
		this.employee_name = employee_name;
		this.employee_phone = employee_phone;
		this.address = address;
	}
	public Employee() {
		
	}
	@Override
	public String toString() {
		return "employee_name=" + employee_name + ", employee_phone=" + employee_phone + ", address="
				+ address + "";
	}
	
	
	
	
	
}
