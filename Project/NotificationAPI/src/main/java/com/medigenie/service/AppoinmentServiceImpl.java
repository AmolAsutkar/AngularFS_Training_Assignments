package com.medigenie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.entity.Notification;
import com.medigenie.scheduleappoinment.repository.AppoinmentRepository;

@Service
public class AppoinmentServiceImpl implements AppoinmentService{

	@Autowired
	AppoinmentRepository appoinmentrepository;
	
	@Override
	public List<Notification> fetchAllAppoinment() {
		List<Notification> appoinmentlist=appoinmentrepository.findAll();
		return appoinmentlist;
	}
	
	

	@Override
	public void saveAppoinment(Notification notification) {
		appoinmentrepository.save(notification);
		
	}

	
	
	}
