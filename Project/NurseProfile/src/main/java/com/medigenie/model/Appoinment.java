package com.medigenie.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="appoinment")

public class Appoinment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="appoinment_id")

	private long id;
	@Column(name="user_id")

	private long userId;
	@Column(name="physician_id")

	private long physicianId;
	
	
	@Column(name="meeting_title")
	private String meetingtitle;
	@Column(name="description")
    private String description;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name="appoinment_date")
    private Date appoinmentDate ;
	
    @Column(name="time")
	private String time;
	@Column(name="reason")
	private String reason;
	@Column(name="Physician")
    private String physicianname;
	
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getPhysicianId() {
		return physicianId;
	}
	public void setPhysicianId(long physicianId) {
		this.physicianId = physicianId;
	}
	public String getMeetingtitle() {
		return meetingtitle;
	}
	public void setMeetingtitle(String meetingtitle) {
		this.meetingtitle = meetingtitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getAppoinmentDate() {
		return appoinmentDate;
	}
	public void setAppoinmentDate(Date appoinmentDate) {
		this.appoinmentDate = appoinmentDate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getPhysicianname() {
		return physicianname;
	}
	public void setPhysicianname(String physicianname) {
		this.physicianname = physicianname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Appoinment(long id, long userId, long physicianId, String meetingtitle, String description,
			Date appoinmentDate, String time, String reason, String physicianname, String firstname, String lastname) {
		super();
		this.id = id;
		this.userId = userId;
		this.physicianId = physicianId;
		this.meetingtitle = meetingtitle;
		this.description = description;
		this.appoinmentDate = appoinmentDate;
		this.time = time;
		this.reason = reason;
		this.physicianname = physicianname;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public Appoinment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
