package com.citiustech.entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Customer")
public class Customer {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	private String customer_name;
	private LocalDate customer_dob;
	private int customer_age;
	private String address;
	private String membership;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public LocalDate getCustomer_dob() {
		return customer_dob;
	}
	public void setCustomer_dob(LocalDate customer_dob) {
		this.customer_dob = customer_dob;
	}
	public int getCustomer_age() {
		return customer_age;
	}
	public void setCustomer_age(int customer_age) {
		this.customer_age = customer_age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMembership() {
		return membership;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}
	
	
	
}
