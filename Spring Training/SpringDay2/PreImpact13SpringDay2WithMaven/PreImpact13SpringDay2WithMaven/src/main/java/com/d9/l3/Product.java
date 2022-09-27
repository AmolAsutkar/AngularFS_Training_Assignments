package com.d9.l3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class Product {
	
	private int product_price;

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		System.out.println("Values are setting up");
		this.product_price = product_price;
	}

	@Override
	public String toString() {
		return "product_price=" + product_price + "";
	}

	@PostConstruct
	public void start() {
		System.out.println("This is my init method");
	}
	
	@PreDestroy
	public void stop() {
		System.out.println("This is my destroy method");
	}
	

}
