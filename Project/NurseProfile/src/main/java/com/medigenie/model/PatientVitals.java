package com.medigenie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_patientsvitals")
public class PatientVitals {
	
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id")
   
	private long id;
	private String Weight ;
	private String BloodPressure ;
	private String BodyTemperature; 
	private String RespirationRate ;
	private long patient_id;
	
	public PatientVitals() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientVitals(long id, String weight, String bloodPressure, String bodyTemperature, String respirationRate,
			long patient_id) {
		super();
		this.id = id;
		Weight = weight;
		BloodPressure = bloodPressure;
		BodyTemperature = bodyTemperature;
		RespirationRate = respirationRate;
		this.patient_id = patient_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWeight() {
		return Weight;
	}

	public void setWeight(String weight) {
		Weight = weight;
	}

	public String getBloodPressure() {
		return BloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		BloodPressure = bloodPressure;
	}

	public String getBodyTemperature() {
		return BodyTemperature;
	}

	public void setBodyTemperature(String bodyTemperature) {
		BodyTemperature = bodyTemperature;
	}

	public String getRespirationRate() {
		return RespirationRate;
	}

	public void setRespirationRate(String respirationRate) {
		RespirationRate = respirationRate;
	}

	public long getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(long patient_id) {
		this.patient_id = patient_id;
	}
	
	
	


}
