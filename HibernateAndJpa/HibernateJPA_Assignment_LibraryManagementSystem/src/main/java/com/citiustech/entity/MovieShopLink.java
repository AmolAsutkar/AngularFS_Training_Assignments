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
@Table(name="MovieShopLink")
public class MovieShopLink {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assignment_id;
	
	@ManyToOne
	@JoinColumn(name = "registered_id")
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name = "shop_id")
	private Shop shop;

	private int copies;
	private LocalDate assignedOn;
	
	public Movie getMovie() {
		return movie;
	}

	public int getAssignment_id() {
		return assignment_id;
	}

	public void setAssignment_id(int assignment_id) {
		this.assignment_id = assignment_id;
	}

	public LocalDate getAssignedOn() {
		return assignedOn;
	}

	public void setAssignedOn(LocalDate assignedOn) {
		this.assignedOn = assignedOn;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}
}
