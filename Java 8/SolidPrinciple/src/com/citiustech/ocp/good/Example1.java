package com.citiustech.ocp.good;

import com.citiustech.ocp.good.Employee.Type;

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
  }
 
 interface TaxCalculator{
	 public double calculateTax(Employee emp) ;
	 
}
class Full_Time implements TaxCalculator{

	@Override
	public double calculateTax(Employee emp) {
		return 0.30;
	}
	
}
class Consultant implements TaxCalculator{

	@Override
	public double calculateTax(Employee emp) {
		return 0.25;
	}
	
}

// factory design pattern
class TaxcalculatorFactory{
	public static TaxCalculator getinstance(Employee emp) {
		
		if(emp.type==Employee.Type.FULL_TIME)
			return new Full_Time();
		if(emp.type==Employee.Type.CONSULTANT)
			return new Consultant();
		return null;
		
	}
	
}