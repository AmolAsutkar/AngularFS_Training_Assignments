package com.d3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpElEx {

	public static int emp_id=101;
	
	@Value("Bhushan")
	private String name;
	//@Value("#{2+2-10}")
	//@Value("#{T(com.d3.SpElEx).emp_id}")
	//@Value("#{T(com.d3.SpElEx).number()}")
	@Value("#{new java.lang.Integer(12)}")
	private int number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "SpElEx [name=" + name + ", number=" + number + "]";
	}
	
	public static int number() {
		return 20;
	}

}
