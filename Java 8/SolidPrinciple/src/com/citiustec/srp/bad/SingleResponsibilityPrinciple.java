package com.citiustec.srp.bad;

public class SingleResponsibilityPrinciple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// this code has 3 stakeholder
//1. PayRoll  
//2.HR
//3.IT
// payroll might change some process in salary
// HR team may change some working hrs
// IT may change the database 
// assume calculatemonthlytimesheet is used internally by calculatemonthlysalary method
//now an intentional change in one method can have unintentional impact on other method
// its very important to test the impact of the change whether we are following srp or not

class Employee{
	
	public double calculateMonthlySalary() {
		return 0;
		
	}
	
    public double calculateMonthlyTimesheet() {
		return 0;
		
	}
    public void saveChanges() {
    	
    }
}