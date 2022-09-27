package com.citiustech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_notification")

	
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long userId;
	private long doctorId;
	private long bookingId;
	
	//@Enumerated(EnumType.STRING)

    @Column(name="NotificationType")

	private  Notificationtype notificationtype;
	
	public Notification(long id, long userId, long doctorId, long bookingId, Notificationtype notificationtype) {
		super();
		this.id = id;
		this.userId = userId;
		this.doctorId = doctorId;
		this.bookingId = bookingId;
		this.notificationtype = notificationtype;
	}
	
	
	public Notificationtype getNotificationtype() {
		return notificationtype;
	}
	public void setNotificationtype(Notificationtype notificationtype) {
		this.notificationtype = notificationtype;
	}
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * public Notification(long id, long userId, long doctorId, long bookingId) {
	 * super(); this.id = id; this.userId = userId; this.doctorId = doctorId;
	 * this.bookingId = bookingId; }
	 */
	
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
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	
}
