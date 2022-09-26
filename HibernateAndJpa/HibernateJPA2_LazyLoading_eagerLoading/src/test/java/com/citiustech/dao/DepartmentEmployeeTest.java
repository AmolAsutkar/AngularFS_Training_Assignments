package com.citiustech.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.citiustech.entity.Department;
import com.citiustech.entity.Employee;

class DepartmentEmployeeTest {

@Test
public void testadddepartment() {
Department dep=new Department();
GenericDao gdao=new GenericDao();

dep.setName("mech");
dep.setLocation("mumbai");
gdao.save(dep);
	}
	

@Test
public void testaddEmployee() {
Employee emp= new Employee();
GenericDao gdao=new GenericDao();
Department dept=gdao.findById(Department.class, 2);


emp.setEmpname("shivani");
emp.setSalary(90000);
emp.setDateofjoining(LocalDate.of(2019,10,12));
emp.setDepartment(dept);
gdao.save(emp);
	}

@Test
public void testFetchEmp() {
GenericDao gdao=new GenericDao();
Employee emp= gdao.findById(Employee.class, 5);

System.out.println(emp.getEmpname()+"----"+emp.getSalary());
Department dept=emp.getDepartment();
System.out.println(dept.getName()+"----"+dept.getLocation());


	}

@Test
public void testFetchDep() {
GenericDao gdao=new GenericDao();
Department dept= gdao.findById(Department.class, 3);
System.out.println(dept.getName()+"----"+dept.getLocation());

for(Employee emp: dept.getEmployee())
System.out.println(emp.getEmpname()+"----"+emp.getSalary());


	}

@Test
public void testFetchEmpWithJpql() {
GenericDao gdao=new GenericDao();
DeptEmpDao ded=new DeptEmpDao();
Employee emp= ded.fetchEmployeeWithDepartment(5);

//Employee emp= ded.fetchEmployee(5);

System.out.println(emp.getEmpname()+"----"+emp.getSalary());
Department dept=emp.getDepartment();
System.out.println(dept.getName()+"----"+dept.getLocation());


	}
}
