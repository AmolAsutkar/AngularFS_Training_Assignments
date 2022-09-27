package com.d3;

public class Employee {
	private String employee_name;
	private String employee_phone;
	private Address address;
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_phone() {
		return employee_phone;
	}
	public void setEmployee_phone(String employee_phone) {
		this.employee_phone = employee_phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [employee_name=" + employee_name + ", employee_phone=" + employee_phone + ", address="
				+ address + "]";
	} 

}
