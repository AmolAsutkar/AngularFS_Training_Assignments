package com.citiustech.code;

public class Person {

	private double weight;
	private double height;
	private Gender gender;
	private int age;
	
	public Person(double weight, double height, Gender gender, int age) {
		super();
		this.weight = weight;
		this.height = height;
		this.gender = gender;
		this.age = age;
	}
	
	public Person(double weight, double height) {
		super();
		this.weight = weight;
		this.height = height;
		
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
	public static enum Gender{
		MALE,FEMALE,OTHER
	}

}
