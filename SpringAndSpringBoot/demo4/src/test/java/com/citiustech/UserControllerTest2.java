package com.citiustech;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.citiustech.controller.UserController;
import com.citiustech.entity.User;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

class UserControllerTest2 {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port; 
	
	@Test
	public void test() {
		String url = "http://localhost:" + port + "/user/{id}";
		User user = restTemplate.getForObject(url, User.class, 5);
		System.out.println(user);
		assertNotNull(user);
	}

}
