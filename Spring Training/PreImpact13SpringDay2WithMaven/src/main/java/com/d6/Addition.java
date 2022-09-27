package com.d6;


//Ambiguity
public class Addition {

	private int num1;
	private int num2;
	
	
	
	
	public Addition(int num1, int num2) {
		System.out.println("This is Int type Constructor");
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public Addition(String num1, String num2) {
		System.out.println("This is String type Constructor");
		this.num1 = Integer.parseInt(num1);
		this.num2 = Integer.parseInt(num2);
	}
	
	public Addition(double num1, double num2) {
		System.out.println("This is Double type Constructor");
		this.num1 = (int)num1;
		this.num2 = (int)num2;
	}
	
	
	
	
	
	
	public void additionResult() {
		System.out.println("Num1 ="+this.num1);
		System.out.println("Num2 ="+this.num2);
		System.err.println("Sum = "+(this.num1+this.num2));
	}
}
