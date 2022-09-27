package com.medigenie.scheduleappoinment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medigenie.dto.UserDTO;
import com.medigenie.model.Appoinment;
import com.medigenie.scheduleappoinment.repository.AppoinmentRepository;

public interface AppoinmentService{

	  // public List<Appoinment> fetchDoctorsAppoinment();
	   public void saveAppoinment(Appoinment appoinment);
	   public void deleteAppoinmentById(Long id);
		public UserDTO findById(long id);
		   public List<Appoinment> fetchAllAppoinment();




}
