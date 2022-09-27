package com.citiustech.stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;




public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1,"asutkar",5868,LocalDate.of(2021, 10, 8)));
		list.add(new Employee(2,"Amol",587645,LocalDate.of(2021, 11, 8)));
		list.add(new Employee(3,"aniket",5860,LocalDate.of(2021, 12, 8)));
		list.add(new Employee(4,"linge",8779,LocalDate.of(2022, 9, 8)));
		list.add(new Employee(5,"manoj",96600,LocalDate.of(2021, 6, 7)));
		
		
		System.out.println("------Example1--------");

		Stream s=list.stream();
		//Iteratot<Employee> itr =list.iterator()
		//for(Employee emp:list)   for each loop internally uses iterator in java
		//stream is just a wrapper of the source from that data 
		
list.stream()
.filter(emp->emp.getSalary()>7000)
.forEach(emp-> System.out.println(emp));


System.out.println("------Example2--------");

Predicate<Employee> con1= emp->emp.getSalary()>7000;
Predicate<Employee> con2= emp->emp.getDateofjoining().getYear()==2022;
list.stream()
.filter(con1.or(con2))
.forEach(emp-> System.out.println("----"+emp));


System.out.println("------Example3--------");
List<Employee> list2=list
.stream()
.filter(emp->emp.getSalary()>7000)
.collect(Collectors.toList());
list2.forEach(emp-> System.out.println(emp));


System.out.println("------Example4--------");
List<Employee> list3=list
.stream()
.filter(emp->emp.getSalary()>7000)
.collect(Collectors.toCollection(LinkedList::new));
list3.forEach(System.out::println); // both are same
list3.forEach(emp-> System.out.println(emp));//same as above

System.out.println("------Example5--------");
Employee[] emparr =list
.stream()
.filter(emp->emp.getSalary()>7000)
.toArray(Employee[]::new);

Stream
.of(emparr)
.forEach(System.out::println);


System.out.println("------Example6--------");
List<String> names=list
.stream()
.map(emp->emp.getEmpname())
.collect(Collectors.toList());
System.out.println(names);


System.out.println("------Example7--------");
List<EmployeeInfo> info=list
.stream()
.map(emp->new EmployeeInfo(emp.empname,emp.dateofjoining))
.collect(Collectors.toList());
info.forEach(System.out::println);


System.out.println("------Example8--------");
List<String> names2=list
.stream()
.filter(emp-> emp.dateofjoining.getYear()==2022)// Condition
.map(emp->emp.getEmpname())   //Transformation
.collect(Collectors.toList());
names2.forEach(System.out::println);


System.out.println("------Example9--------");
List<Employee> emps=list
.stream()
.filter(emp-> emp.getSalary()>8000)// Condition
.sorted(Comparator.comparing(Employee::getEmpname))

.collect(Collectors.toList());
emps.forEach(System.out::println);


// write a stream to find out total salary
System.out.println("------Example10--------");
int total = list.stream().collect(
		   Collectors.summingInt(Employee::getSalary));
		  System.out.println("Total Employees Salary : " + total);
		  
		  //OR
 Double totalsalary =list
.stream()
.mapToDouble(Employee::getSalary)
.sum();
 System.out.println(totalsalary);
 
 
 //similarly we can do for min,max,count
 
 
 System.out.println("------Example11--------");
 List<Employee> emps2 = list
.stream()
.filter(emp -> emp.getSalary()>8000)
.peek(emp->emp.deductTax())
.peek(System.out::println)
.collect(Collectors.toList());
 
 
 System.out.println("------Example12 parallel stream--------");
 
 List<String> emps3= list
.parallelStream()
.filter(emp ->{ 
System.out.println("filter "+Thread.currentThread().getName());
 return emp.getSalary() > 8000;
 })

.map(emp-> {
	System.out.println("map "+Thread.currentThread().getName());
	 return emp.getEmpname();
})

.collect(Collectors.toList());
 
 
 //create a stream containing an arrayas its element
 //then using flatmap extract the individual elements of that array
 System.out.println("------Example13 parallel stream--------");
  
//int [] intarr= {1,2,3,4,4};
//Stream<int[]> strarr=Stream.of(null)

}

class Employee{
	
	int empno;
	String empname;
	int salary;
	LocalDate dateofjoining;
	
	
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", empname=" + empname + ", salary=" + salary + ", dateofjoining="
				+ dateofjoining + ", getEmpno()=" + getEmpno() + ", getEmpname()=" + getEmpname() + ", getSalary()="
				+ getSalary() + ", getDateofjoining()=" + getDateofjoining() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public void deductTax() {
		this.salary=(int) (salary-salary*0.20);
	}
	
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDate getDateofjoining() {
		return dateofjoining;
	}

	public void setDateofjoining(LocalDate dateofjoining) {
		this.dateofjoining = dateofjoining;
	}

	
	
	Employee() {
		
	}
	
	Employee(int empno, String empname, int salary, LocalDate dateofjoining) {
		super();
		this.empno = empno;
		this.empname = empname;
		this.salary = salary;
		this.dateofjoining = dateofjoining;
	}
	
}

class EmployeeInfo{
	
	String empname;
	LocalDate dateofjoining;

	public EmployeeInfo(String empname, LocalDate dateofjoining) {
		super();
		this.empname = empname;
		this.dateofjoining = dateofjoining;
	}

	@Override
	public String toString() {
		return "EmployeeInfo [empname=" + empname + ", dateofjoining=" + dateofjoining + ", getEmpname()="
				+ getEmpname() + ", getDateofjoining()=" + getDateofjoining() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public LocalDate getDateofjoining() {
		return dateofjoining;
	}
	public void setDateofjoining(LocalDate dateofjoining) {
		this.dateofjoining = dateofjoining;
	}
}

