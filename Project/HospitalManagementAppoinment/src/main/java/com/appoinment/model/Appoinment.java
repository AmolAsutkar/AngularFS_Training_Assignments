package com.appoinment.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name="meeting_title")
	private String meetingtitle;
	@Column(name="description")
    private String description;
	@Column(name="Physician")
    private String Physician;
	
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name="appoinment_date")
    private Date appoinmentDate ;
	
    @Column(name="time")
	private Time time;
	@Column(name="reason")
	private String reason;
	
}
