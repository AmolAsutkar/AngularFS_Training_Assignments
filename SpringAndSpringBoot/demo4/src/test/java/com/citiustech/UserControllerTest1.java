package com.citiustech;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.citiustech.controller.UserController;
import com.citiustech.entity.User;

class UserControllerTest1 {

	@Autowired
	private UserController userController;
	
	@Test
	public void test() {
		User user = userController.get(4);
		assertNotNull(user);
	}

}
