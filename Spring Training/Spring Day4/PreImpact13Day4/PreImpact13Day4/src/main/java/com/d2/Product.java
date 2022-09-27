package com.d2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class Product {
	@Value("101")
	private int prod_id;
	@Value("Iphone 12 mini")
	private String prod_name;
	@Value("55000")
	private float prod_price;
	//@Autowired
	private ProductDesc prod_desc;

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public float getProd_price() {
		return prod_price;
	}

	public void setProd_price(float prod_price) {
		this.prod_price = prod_price;
	}

	public ProductDesc getProd_desc() {
		return prod_desc;
	}

	public void setProd_desc(ProductDesc prod_desc) {
		this.prod_desc = prod_desc;
	}

	@Override
	public String toString() {
		return "prod_id=" + prod_id + ", prod_name=" + prod_name + ", prod_price=" + prod_price
				+ ", prod_desc=" + prod_desc + "";
	}

	
}
