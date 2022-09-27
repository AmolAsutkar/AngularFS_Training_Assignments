package com.medigenie.appoinmentscheduling.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Time;



@Entity
@Table(name="tbl_cust")
public class Appointment {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String meetingtitle;
	private String description;
	private String Physician;
    private LocalDate Date ;
	private Time time;
	private String reason;

	
}
