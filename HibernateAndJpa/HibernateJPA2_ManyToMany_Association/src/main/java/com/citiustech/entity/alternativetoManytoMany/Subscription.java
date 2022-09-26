package com.citiustech.entity.alternativetoManytoMany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="SubscriptionEx2")
@Table(name="tablesubs")
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subsid;
	private String type;
	private double cost;
	private int duration;
	
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
	
}
