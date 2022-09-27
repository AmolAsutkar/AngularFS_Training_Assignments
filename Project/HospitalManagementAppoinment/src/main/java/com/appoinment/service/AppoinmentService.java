package com.appoinment.service;

import java.util.List;

import com.appoinment.model.Appoinment;


public interface AppoinmentService {
	
	 public List<Appoinment> fetchAllAppoinment();
	   public void saveAppoinment(Appoinment appoinment);
}
