package com.citiustech.dto;

import java.util.Date;

import com.citiustech.enums.AppointmentStatus;

import lombok.Data;

@Data
public class AppointmentDTO {

	private long userId;
	private long physicianId;
	private String meetingtitle;
	private String description;
	private Date appoinmentDate;
	private String time;
	private String reason;
	private String physicianname;
	private String firstname;
	private String lastname;
	private AppointmentStatus status;
	private String patientName;
	
	
	public AppointmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AppointmentDTO(long userId, long physicianId, String meetingtitle, String description, Date appoinmentDate,
			String time, String reason, String physicianname, String firstname, String lastname,
			AppointmentStatus status, String patientName) {
		super();
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
		this.status = status;
		this.patientName = patientName;
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
	public AppointmentStatus getStatus() {
		return status;
	}
	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	
}
