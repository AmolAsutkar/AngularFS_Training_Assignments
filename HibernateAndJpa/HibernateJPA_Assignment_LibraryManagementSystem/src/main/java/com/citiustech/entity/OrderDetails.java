package com.citiustech.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="OrderDetails")

public class OrderDetails {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	
	private String order_type;
	
	private double totalCost;
	
	private LocalDate orderPlacedOn;
	
	private LocalDate orderReturnDate;
	
	@ManyToOne
	@JoinColumn(name = "assigned_id")
	private MovieShopLink movieShopLink;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public LocalDate getOrderPlacedOn() {
		return orderPlacedOn;
	}

	public void setOrderPlacedOn(LocalDate orderPlacedOn) {
		this.orderPlacedOn = orderPlacedOn;
	}

	public MovieShopLink getMovieShopLink() {
		return movieShopLink;
	}

	public void setMovieShopLink(MovieShopLink movieShopLink) {
		this.movieShopLink = movieShopLink;
	}

	public LocalDate getOrderReturnDate() {
		return orderReturnDate;
	}

	public void setOrderReturnDate(LocalDate orderReturnDate) {
		this.orderReturnDate = orderReturnDate;
	}
}