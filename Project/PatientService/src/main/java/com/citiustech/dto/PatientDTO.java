package com.citiustech.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.citiustech.model.Allergy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

	private long id;
	
	private long userId;
	
	private String patientFirstName;
	private String patientLastName;
	private String patientEmail;
	private String patientMobileNumber;
	private String patientHomeAddress;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private String homeAddress;
	private Set<Allergy> allergies;
	

}
