package com.citiustech.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shop_id;
	private String shop_address;
	private String manager;
	private String firstShiftStaff;
	private String secondShiftStaff;
	
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "staff_id")
	private Staff staff;
	
	public int getShop_id() {
		return shop_id;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public String getShop_address() {
		return shop_address;
	}
	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getFirstShiftStaff() {
		return firstShiftStaff;
	}
	public void setFirstShiftStaff(String firstShiftStaff) {
		this.firstShiftStaff = firstShiftStaff;
	}
	public String getSecondShiftStaff() {
		return secondShiftStaff;
	}
	public void setSecondShiftStaff(String secondShiftStaff) {
		this.secondShiftStaff = secondShiftStaff;
	}
	
}
