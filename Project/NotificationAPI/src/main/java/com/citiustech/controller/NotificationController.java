package com.citiustech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.citiustech.entity.Notification;
import com.medigenie.service.AppoinmentService;
import com.citiustech.service.NotificationService;

@RestController
public class NotificationController {
    
@Autowired
	AppoinmentService appoinmentservice;

@Autowired	
NotificationService notificationService;
	
/*	@PostMapping("/sendnotification")
public void notify(@RequestBody Notification notification) {
	notificationService.sendNotification(notification);
	
}
	*/

	@PostMapping("/save")
	public void saveAppoinment(@RequestBody Notification notification) {
		appoinmentservice.saveAppoinment(notification);
	}
	
	@GetMapping("/get")
	public List<Notification> seeAllAppoinment() {
		return appoinmentservice.fetchAllAppoinment();
	}
}


