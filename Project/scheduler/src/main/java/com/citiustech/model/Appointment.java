package com.citiustech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.citiustech.enums.AppointmentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="patient_id")
	private long userId;
	
	@Column(name="physician_id")
	private long physicianId;
	
	@Column(name="meeting_title")
	private String meetingTitle;
	
	@Column(name="appoinment_date")
    private Date appoinmentDate ;
	
    @Column(name="time")
	private String time;

	@Column(name="physician_name")
    private String physicianName;
	
	@Column(name = "patient_name")
	private String patientName;
	
	@Column(name = "description")

	private String description;

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "appointment_status")
	@Enumerated(EnumType.STRING)
	private AppointmentStatus status;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(long id, long userId, long physicianId, String meetingTitle, Date appoinmentDate, String time,String description,
			String physicianName, String patientName, AppointmentStatus status) {
		super();
		this.id = id;
		this.userId = userId;
		this.physicianId = physicianId;
		this.meetingTitle = meetingTitle;
		this.appoinmentDate = appoinmentDate;
		this.time = time;
		this.physicianName = physicianName;
		this.patientName = patientName;
		this.status = status;
		this.description=description;
	}

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

	public String getMeetingTitle() {
		return meetingTitle;
	}

	public void setMeetingTitle(String meetingTitle) {
		this.meetingTitle = meetingTitle;
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

	public String getPhysicianName() {
		return physicianName;
	}

	public void setPhysicianName(String physicianName) {
		this.physicianName = physicianName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}
	
	

}
