package com.citiustech.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="tbl_cust")
@XmlRootElement
@ApiModel("entity representing")
public class Customer {

	@ApiModelProperty(notes ="unique property")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custId;
	
	@ApiModelProperty(notes="name of person",example="Ampl",required = true)
	private String  CustName;
	private String  email;
   private LocalDate dateofbirth;

@OneToOne(cascade = CascadeType.MERGE)  // wthatever operation performed on parent will also perform on child using cascase
@JoinColumn(name="addrId_FKey")  // foreign key mapping
//@OneToOne
Address address;

	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", CustName=" + CustName + ", email=" + email + ", dateofbirth="
				+ dateofbirth + "]";
	}

	

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
}
