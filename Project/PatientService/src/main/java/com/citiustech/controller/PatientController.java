package com.citiustech.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.citiustech.model.Patient;
import com.citiustech.repository.PatientRepository;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

	@Autowired
	PatientRepository patientRepository;
	
	
	@PostMapping("/addPatient")
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
	    Patient patientOne = patientRepository.save(patient);
	    return new ResponseEntity<>(patientOne, HttpStatus.CREATED);
	  }
	
	@GetMapping("/getPatients")
	public ResponseEntity<List<Patient>> getAllPatients() {
	    List<Patient> patients = new ArrayList<Patient>();
	    patientRepository.findAll();
	      
	    if (patients.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(patients, HttpStatus.OK);
	  }
	
	
	@GetMapping("/getPatientById/{patientId}")
	  public ResponseEntity<Patient> getTutorialById(@PathVariable("patientId") long patientId) {
	    Patient patient = patientRepository.findById(patientId)
	        .orElseThrow(() -> new ResourceAccessException("Not found Tutorial with id = " + patientId));
	    return new ResponseEntity<>(patient, HttpStatus.OK);
	  }
	
	@PutMapping("/updatePatient/{patientId}")
	public ResponseEntity<Patient> updateTutorial(@PathVariable("patientId") long patientId, @RequestBody Patient patient) {
	    Patient patientOne = patientRepository.findById(patientId)
	        .orElseThrow(() -> new ResourceAccessException("Not found Tutorial with id = " + patientId));
	    
	    
	    return new ResponseEntity<>(patientRepository.save(patientOne), HttpStatus.OK);
	  }
	
	
	

}
