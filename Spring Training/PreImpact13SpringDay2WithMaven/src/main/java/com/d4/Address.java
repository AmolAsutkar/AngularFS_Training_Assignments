package com.d4;

public class Address {
	private String city;
	private String state;
	private String country;
	public Address(String city, String state, String country) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "city=" + city + ", state=" + state + ", country=" + country + "";
	}
	
	
}
