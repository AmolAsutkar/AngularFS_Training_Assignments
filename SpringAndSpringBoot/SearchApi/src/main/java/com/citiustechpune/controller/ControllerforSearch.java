package com.citiustechpune.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.citiustechpune.service.SearchService;

@RestController
public class ControllerforSearch {

	@Autowired
	SearchService searchservice;
	
	@GetMapping("/searchspeciality/{name}")
	public String searchspeciality(){
		return searchservice.searchBySpeciality();
	}
	
	@GetMapping("/searchhospital/{hospitalid}")
	public String searchhospital(@PathVariable("id") int id){
		return searchservice.searchHospitalById();
	}
	
	@GetMapping("/searchhospital/{hospitalname}")
	public String searchhospitalByName(){
		return searchservice.searchHospitalByName();
	}
}
