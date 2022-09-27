package com.citiustech.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_allergy")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Allergy {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id")
	  private long id;
	  
	  private String AllergyID;
	  
	  private String AllergyType;
	  
	  private String AllergyName;
	  
	  private String AllergenSource;
	  
	  private String IsoformsOrPartialSequencesOfAllergen;
	  
	  private String Allerginicity;
	  
	  @ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      })
		  @JsonIgnore
		  private Set<Patient> patients = new HashSet<>();
	  
	  
}
