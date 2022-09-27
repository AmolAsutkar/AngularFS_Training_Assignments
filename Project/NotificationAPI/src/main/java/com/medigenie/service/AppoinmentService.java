package com.medigenie.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.citiustech.entity.Notification;

@Service
public interface AppoinmentService {

	   public List<Notification> fetchAllAppoinment();
	   public void saveAppoinment(Notification notification);


}
