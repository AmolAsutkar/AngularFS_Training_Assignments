package com.citiustech.dto;

import java.time.LocalDate;

public class CustomerInfo {

private int id;
	
	private String  city;
	private String  state;
    private int pincode;
	
	private String  CustName;
	private String  email;
   private LocalDate dateofbirth;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
public String getCustName() {
	return CustName;
}
public void setCustName(String custName) {
	CustName = custName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public LocalDate getDateofbirth() {
	return dateofbirth;
}
public void setDateofbirth(LocalDate dateofbirth) {
	this.dateofbirth = dateofbirth;
}
   
}
