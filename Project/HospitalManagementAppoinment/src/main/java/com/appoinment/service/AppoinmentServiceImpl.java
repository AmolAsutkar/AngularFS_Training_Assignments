package com.appoinment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appoinment.model.Appoinment;
import com.appoinment.repository.AppoinmentRepo;

@Service
public class AppoinmentServiceImpl {

	@Autowired
	AppoinmentRepo appoinmentRepo;
	
	
	
	  public List<Appoinment> fetchAllAppoinment() { 
		  List<Appoinment> appoinmentlist=appoinmentRepo.findAll(); 
	  
	  return appoinmentlist;
	  
	  }
	  
	  
	  public void saveAppoinment(Appoinment appoinment) {
	  appoinmentRepo.save(appoinment);
	  
	  }
	 

}
