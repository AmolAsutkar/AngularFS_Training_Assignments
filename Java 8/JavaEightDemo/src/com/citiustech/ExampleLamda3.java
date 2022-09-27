package com.citiustech;

import java.util.ArrayList;
import java.util.List;

public class ExampleLamda3 {

	public static void main(String[] args) {

		
		List<Emp> list = new ArrayList<>();
		list.add(new Emp(1,"asutkar",5868));
		list.add(new Emp(2,"aniket",58680));
		list.add(new Emp(3,"amol",586800));
		
		for(Emp emp:list) {
			System.out.println(emp.empno +"  "+ emp.empname +"  "+emp.empsalary+"  ");
		}
		
		list.forEach(emp-> System.out.println(emp.empno +"  "+ emp.empname +"  "+emp.empsalary+"  "));
        
		list.sort((e1,e2)-> e1.empname.compareTo(e2.empname));
		list.forEach(emp-> System.out.println(emp.empno +"  "+ emp.empname +"  "+emp.empsalary+"  "));

	}

}
   class Emp{
	int empno;
	String empname;
	int empsalary;
	
	
	 Emp(int empno, String empname, int empsalary) {
		super();
		this.empno = empno;
		this.empname = empname;
		this.empsalary = empsalary;
	}
	
	
}
