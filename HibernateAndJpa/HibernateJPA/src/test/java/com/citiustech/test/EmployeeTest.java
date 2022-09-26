package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.EmployeeDao;
import com.citiustech.entity.Employee;

public class EmployeeTest {

	@Test
	public void add() {
		Employee emp=new Employee();
		//e.setEmpno();
		emp.setName("Amol");
		emp.setSalary(5000);
		emp.setDateOfJoining(LocalDate.of(2021, 10, 15));
		
		EmployeeDao empdao=new EmployeeDao();
		int empno=empdao.add(emp);
		assertTrue(empno>0);
	}
	
	@Test
	public void testFetch() {
		
		
		EmployeeDao empdao=new EmployeeDao();
		Employee empdata=empdao.fetch(2);
	//	System.out.println(empdata.getName());
assertNotNull(empdata);
	}
}
