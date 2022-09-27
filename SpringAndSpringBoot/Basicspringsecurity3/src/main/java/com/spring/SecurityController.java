package com.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class SecurityController {
	
	
	@RequestMapping("/load")
	public String loadPage()
	{
		return "welcome to the security world";
	}
	
	
	@GetMapping("/user/dashboard")
	public String userDashboard() {
		return "Welcome User";
	}
	
	@GetMapping("/admin/dashboard")
	public String adminDashboard() {
		return "Welcome admin";
	}
}
