package com.citiustechpune.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchService {

	@Autowired
	RestTemplate restTemplate;
	
	public String searchBySpeciality() {
		String url="http://localhost:8080/searchBySpeciality";
		restTemplate.getForObject("http://localhost:9090/doctor-speciality/doctor/speciality/findById/", Object.class);
	    return "search by speciality";
	   }

	public String searchHospitalById() {

		String url="http://localhost:9090/searchByHospital";
		restTemplate.getForObject("http://localhost:9090/doctor-speciality/doctor/speciality/findById/", Object.class);

	    return "search by Hospitalid";
	  }
	
	public String searchHospitalByName() {

		String url="http://localhost:9090/searchByHospital";
		restTemplate.getForObject("http://localhost:9090/doctor-speciality/doctor/speciality/findById/", Object.class);

	    return "search by Hospitalname";
	  }
}
