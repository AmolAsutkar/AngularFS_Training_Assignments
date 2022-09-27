package com.citiustech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citiustech.entity.Notification;
import com.citiustech.repository.GenericRepo;

@Service
public class NotificationService {

	@Autowired
	GenericRepo genericRepo;
	
	@Transactional
   public void sendNotification(Notification notification) {
	genericRepo.save(notification);
  }

}
