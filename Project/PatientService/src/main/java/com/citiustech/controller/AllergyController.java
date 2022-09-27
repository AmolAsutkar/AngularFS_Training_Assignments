package com.citiustech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.multipart.MultipartFile;

import com.citiustech.helper.ExcelHelper;
import com.citiustech.model.Allergy;
import com.citiustech.model.Patient;
import com.citiustech.repository.AllergyRepository;
import com.citiustech.repository.PatientRepository;
import com.citiustech.response.ResponseMessage;
import com.citiustech.service.AllergyService;
import com.citiustech.service.ExcelDataServiceImpl;
import com.citiustech.service.FileUploaderImpl;

@RestController
@RequestMapping("/api/excel")
@CrossOrigin(origins = "http://localhost:4200")
public class AllergyController {

	@Autowired
	AllergyService fileService;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	AllergyRepository allergyRepository;
	
	@PostMapping(value = "/upload", consumes = "multipart/form-data")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam MultipartFile file) {
	    String message = "";
	    System.out.println("in upload");
	    if (ExcelHelper.hasExcelFormat(file)) {
	      
	        fileService.save(file);
	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	     
	    }
	    message = "Please upload an excel file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	  }
	
	@GetMapping("/getAllAllergy")
	  public ResponseEntity<List<Allergy>> getAllAllergy() {
	    try {
	      List<Allergy> allergies = fileService.getAllAllergy();
	      if (allergies.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(allergies, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/allergyByType/{AllergyType}")
	  public ResponseEntity<List<Allergy>> getAllergyByType(@PathVariable(value="AllergyType") String AllergyType) {
	    try {
	      List<Allergy> allergies = fileService.getAllergyByType(AllergyType);
	      if (allergies.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(allergies, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	
	@GetMapping("/{patientId}/allergyByPatientId")
	  public ResponseEntity<List<Allergy>> getAllAllergiesByPatientId(@PathVariable(value = "patientId") Long patientId) {
	    if (!patientRepository.existsById(patientId)) {
	      throw new ResourceAccessException("Not found Tutorial with id = " + patientId);
	    }
	    List<Allergy> allergies = allergyRepository.findAllergyByPatientsId(patientId);
	    return new ResponseEntity<>(allergies, HttpStatus.OK);
	  }
	
	@GetMapping("/{allergyId}/patientByAllergyId")
	  public ResponseEntity<List<Patient>> getAllTutorialsByTagId(@PathVariable(value = "allergyId") Long allergyId) {
	    if (!allergyRepository.existsById(allergyId)) {
	      throw new ResourceAccessException("Not found Tag  with id = " + allergyId);
	    }
	    List<Patient> patients = patientRepository.findPatientsByAllergiesId(allergyId);
	    return new ResponseEntity<>(patients, HttpStatus.OK);
	  }
	
	@PostMapping("/{patientId}/addAllergy")
	  public ResponseEntity<Allergy> addTag(@PathVariable(value = "patientId") Long patientId, @RequestBody Allergy allergyRequest) {
	    Allergy allergy = patientRepository.findById(patientId).map(patient -> {
	      long allergyId = allergyRequest.getId();
	      
	      if (allergyId != 0L) {
	        Allergy allergyOne = allergyRepository.findById(allergyId)
	            .orElseThrow(() -> new ResourceAccessException("Not found Tag with id = " + allergyId));
	        patient.addAllergy(allergyOne);
	        patientRepository.save(patient);
	        return allergyOne;
	      }
	      
	      patient.addAllergy(allergyRequest);
	      return allergyRepository.save(allergyRequest);
	    }).orElseThrow(() -> new ResourceAccessException("Not found Tutorial with id = " + patientId));
	    return new ResponseEntity<>(allergy, HttpStatus.CREATED);
	  }
}

