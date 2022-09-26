package com.citiustech.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subscripition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subsid;
	private String type;
	private double cost;
	private int duration;
	
	@ManyToMany(mappedBy = "subscription")
	List<User> user;
	
	public int getSubsid() {
		return subsid;
	}

	public void setSubsid(int subsid) {
		this.subsid = subsid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	

}
