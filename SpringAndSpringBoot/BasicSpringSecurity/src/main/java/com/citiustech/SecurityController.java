package com.citiustech;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	@RequestMapping("/load")
	public String loadPage() {
		return "welcome to security world";
	}

}
