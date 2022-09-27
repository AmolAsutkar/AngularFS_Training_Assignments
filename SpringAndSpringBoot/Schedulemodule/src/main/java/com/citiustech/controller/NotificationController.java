package com.citiustech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.citiustech.entity.Notification;
import com.citiustech.service.NotificationService;

@RestController
public class NotificationController {
    
	@Autowired
	NotificationService notificationService;
	
	@PostMapping("/sendnotification")
	public void notify(@RequestBody Notification notification) {
		notificationService.sendNotification(notification);
	
	}
	
}
