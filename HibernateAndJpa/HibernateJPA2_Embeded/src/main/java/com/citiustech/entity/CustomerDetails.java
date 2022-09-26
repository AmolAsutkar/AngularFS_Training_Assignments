package com.citiustech.entity;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity(name="cust_details")
public class CustomerDetails {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;

	@ElementCollection
	@CollectionTable(name = "Customer2_Hobbies",
					 joinColumns = @JoinColumn(name = "cust_id"))
	private List<String> hobbies;

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "city", column = @Column(name = "billing_city")),
		@AttributeOverride(name = "state", column = @Column(name = "billing_state")),
		@AttributeOverride(name = "pincode", column = @Column(name = "billing_pincode"))
	})
	private AddressDetails billingAddress;
	
	

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "city", column = @Column(name = "shipping_city")),
		@AttributeOverride(name = "state", column = @Column(name = "shipping_state")),
		@AttributeOverride(name = "pincode", column = @Column(name = "shipping_pincode"))
	})
	private AddressDetails shippingAddress;

	
	
	public AddressDetails getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(AddressDetails billingAddress) {
		this.billingAddress = billingAddress;
	}

	public AddressDetails getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(AddressDetails shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	

}
