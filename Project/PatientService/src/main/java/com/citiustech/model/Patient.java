package com.citiustech.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long userId;
	
	private String patientFirstName;
	private String patientLastName;
	private String patientEmail;
	private String patientMobileNumber;
	private String patientHomeAddress;
	
	private String languageKnown;
	
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private String homeAddress;
	
	
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      })
	@JoinTable(name = "patient_allergy",
				joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "allergy_id", referencedColumnName = "id")
				)
	private Set<Allergy> allergies = new HashSet<>();
	
	
	public void addAllergy(Allergy allergy) {
	    this.allergies.add(allergy);
	    allergy.getPatients().add(this);
	  }
	  
	  public void removeAllergy(long allergyId) {
	    Allergy allergy = this.allergies.stream().filter(t -> t.getId() == allergyId).findFirst().orElse(null);
	    if (allergy != null) {
	      this.allergies.remove(allergy);
	      allergy.getPatients().remove(this);
	    }
	  }
	 
	
	
	

}
