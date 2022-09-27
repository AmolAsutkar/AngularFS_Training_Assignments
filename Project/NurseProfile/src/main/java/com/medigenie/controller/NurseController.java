package com.medigenie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.medigenie.constant.Constant;
import com.medigenie.dto.ResponseDTO;
import com.medigenie.dto.UserDTO;
import com.medigenie.model.Appoinment;
import com.medigenie.model.PatientVitals;
import com.medigenie.service.PatientsVitalsService;

@RestController
@CrossOrigin(origins="*")
public class NurseController {
	
	@Autowired
	private HttpServletRequest request;
	
	PatientVitals PatientVitals=new PatientVitals();
	
	@Autowired
	PatientsVitalsService patientsvitalsservice;
	
	
	@PostMapping("/addpatientsvitals")

	public ResponseEntity<ResponseDTO> addPatientVitals(@RequestBody PatientVitals patientvitals ) {
		ResponseDTO responsedto=new ResponseDTO();
		RestTemplate restemplate = new RestTemplate();
	    //String url="http://localhost:8070/api/user/findById/" ;
		//UserDTO result=restemplate.getForObject(url, UserDTO.class);
		patientsvitalsservice.AddPatientvitals(patientvitals);
		responsedto.setStatus(HttpStatus.OK);
		responsedto.setMessage(Constant.SAVE_SUCCESS);
		return new ResponseEntity<>(responsedto,responsedto.getStatus());
	}
	
	
	
	
	
}
