package com.appoinment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appoinment.model.Appoinment;
import com.appoinment.service.AppoinmentService;
import com.appoinment.service.AppoinmentServiceImpl;




@RestController
public class AppoinmentController {

	@Autowired
	AppoinmentServiceImpl appoinmentService;
	
	@PostMapping("/save")
	public void saveAppoinment(@RequestBody Appoinment appoinment) {
		appoinmentService.saveAppoinment(appoinment);
	}
	
	
	@GetMapping("/get")
	public List<Appoinment> seeAllAppoinment() {
		return appoinmentService.fetchAllAppoinment();
}
}