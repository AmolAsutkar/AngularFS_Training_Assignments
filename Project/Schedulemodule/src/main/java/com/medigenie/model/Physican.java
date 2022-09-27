package com.medigenie.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="physican_Details")
public class Physican {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long appoinmentId;
	private String firstName;
	private String lastName;
	private String title;
	private String status;
	private String appoinmentdate;
	private String appoinmenttime;
	private String physicanname;
	
	public Physican() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Physican(long appoinmentId, String firstName, String lastName, String title, String status,
			String appoinmentdate, String appoinmenttime, String physicanname) {
		super();
		this.appoinmentId = appoinmentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.status = status;
		this.appoinmentdate = appoinmentdate;
		this.appoinmenttime = appoinmenttime;
		this.physicanname = physicanname;
	}
	public long getAppoinmentId() {
		return appoinmentId;
	}
	public void setAppoinmentId(long appoinmentId) {
		this.appoinmentId = appoinmentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAppoinmentdate() {
		return appoinmentdate;
	}
	public void setAppoinmentdate(String appoinmentdate) {
		this.appoinmentdate = appoinmentdate;
	}
	public String getAppoinmenttime() {
		return appoinmenttime;
	}
	public void setAppoinmenttime(String appoinmenttime) {
		this.appoinmenttime = appoinmenttime;
	}
	public String getPhysicanname() {
		return physicanname;
	}
	public void setPhysicanname(String physicanname) {
		this.physicanname = physicanname;
	}
	
	

}
