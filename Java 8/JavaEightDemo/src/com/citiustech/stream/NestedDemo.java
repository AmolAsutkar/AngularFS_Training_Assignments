package com.citiustech.stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NestedDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Customer> custlist=new ArrayList<>();
		
		Customer c1=new Customer("amol","amol@gmail.com");
		Order o1=new Order(c1, LocalDate.of(2022, 10, 9), 7500);
		Order o2=new Order(c1, LocalDate.now(), 8500);
		
		Customer c2=new Customer("asutkar","asutkar@gmail.com");
		Order o3=new Order(c2, LocalDate.of(2022, 10, 9), 7500);
		Order o4=new Order(c2, LocalDate.now(), 9500);

		
		custlist.add(c1);
		custlist.add(c2);
		
		System.out.println("-------Example 1 flat map--------");
		List<Order> orders=custlist
				.stream()
				.flatMap(cust-> cust.Orders.stream())
				.filter(ord-> ord.OrderDate.equals(LocalDate.now()))
				.collect(Collectors.toList());
orders.forEach(ord ->System.out.println(ord.amount+" "+ord.OrderDate+" "+ord.customer.name));
		

System.out.println("-------Example 2 flat map--------");
double totalsales=custlist
		.stream()
		.flatMap(cust-> cust.Orders.stream())
		.map(ord -> ord.amount)
		.reduce(0.0, Double::sum); // sum is method of double class
System.out.println(totalsales);

	
	
	}

}

class Customer{
	String name;
	String email;
	List<Order> Orders;

	public Customer(String name, String email) {
		super();
		this.name = name;
		this.email = email;
		this.Orders = new ArrayList<Order>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Order> getOrders() {
		return Orders;
	}
	public void setOrders(List<Order> orders) {
		Orders = orders;
	}
	
	
}

class Order{
	LocalDate OrderDate;
	double amount;
	Customer customer;

	
	public Order(Customer customer,LocalDate OrderDate, double amount) {
		super();
		this.customer=customer;
		this.OrderDate = OrderDate;
		this.amount = amount;
		customer.Orders.add(this);
	}

	
	public LocalDate getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(LocalDate OrderDate) {
		this.OrderDate = OrderDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
