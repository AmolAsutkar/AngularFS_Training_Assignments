package com.citiustech.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MovieIssued")
public class MovieIssued {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int issue_id;
	
	@ManyToOne
	@JoinColumn(name = "registered_id")
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	private LocalDate issueDate;
	
	private LocalDate returnDate;

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	private int durationInDays;
	
	private double rentCost;

	public int getIssue_id() {
		return issue_id;
	}

	public void setIssue_id(int issue_id) {
		this.issue_id = issue_id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public int getDurationInDays() {
		return durationInDays;
	}

	public void setDurationInDays(int durationInDays) {
		this.durationInDays = durationInDays;
	}

	public double getRentCost() {
		return rentCost;
	}

	public void setRentCost(double rentCost) {
		this.rentCost = rentCost;
	}
}
