package com.medigenie.scheduleappoinment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medigenie.dto.UserDTO;
import com.medigenie.model.Appoinment;
import com.medigenie.scheduleappoinment.repository.AppoinmentRepository;

@Service
public class AppoinmentServiceImpl implements AppoinmentService{

	@Autowired
	AppoinmentRepository appoinmentrepository;
	
	@Override
	public List<Appoinment> fetchAllAppoinment() {
		List<Appoinment> appoinmentlist=appoinmentrepository.findAll();
		//	List<Appoinment> appoinmentlist=appoinmentrepository.findAllfuturedate();

		return appoinmentlist;
	}
	
	@Override
	public void saveAppoinment(Appoinment appoinment) {
		System.out.println(appoinment.getPhysicianId()+"appoinments");
		appoinmentrepository.save(appoinment);
		
		
	}

	@Override
	public void deleteAppoinmentById(Long id) {
		appoinmentrepository.deleteById(id);
	}

	@Override
	public UserDTO findById(long id) {
		UserDTO userDTO = new UserDTO();

		appoinmentrepository.findById(id);
		return userDTO;
	}

	
	
	}
