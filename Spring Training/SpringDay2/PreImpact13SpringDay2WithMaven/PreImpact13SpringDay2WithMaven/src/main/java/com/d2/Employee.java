package com.d2;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Employee {
	
	private String employee_name;
	private List<String> phones;
	private Set<String> address;
	private Map<String, String> department;
	
	
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public List<String> getPhones() {
		return phones;
	}
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	public Set<String> getAddress() {
		return address;
	}
	public void setAddress(Set<String> address) {
		this.address = address;
	}
	public Map<String, String> getDepartment() {
		return department;
	}
	public void setDepartment(Map<String, String> department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "employee_name=" + employee_name + ", phones=" + phones + ", address=" + address
				+ ", department=" + department + "]";
	}
	
	
	
	
	

}
