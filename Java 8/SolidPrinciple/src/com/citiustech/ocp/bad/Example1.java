package com.citiustech.ocp.bad;

import com.citiustech.ocp.bad.Employee.Type;

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Employee{
	int id;
	Type type;
	
	static enum Type{
		FULL_TIME,CONSULTANT;
	}
}

class salaryCalculator{
	private TaxCalculator taxCalculator;
	 public double calculateSalary(Employee emp) {
		 double tax=taxCalculator.calculateTax(emp);
		 return 0;
	 }
	 
	 // the problem here is we have to change calculateTax method everytime new employee is introduced
 class TaxCalculator{
	 public double calculateTax(Employee emp) {
		 if(emp.type==Type.FULL_TIME)
			 return 0;
		 else if(emp.type==Type.CONSULTANT)
		 return 0;
		return 0;
		 
	 }
	 }
}