package com.citiustech;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.citiustech.controller.UserController;
import com.citiustech.entity.User;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
class UserControllerTest3 {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test() throws Exception {
		User expected = new User(4, "Amol", "amol@123");
		ObjectMapper mapper = new ObjectMapper();
		String expectedJson = mapper.writeValueAsString(expected);
		
		MvcResult result = mockMvc
							.perform(get("/user/{id}", 4))
							.andDo(print())
							.andExpect(status().isOk())
							.andReturn();
		String actualJson = result.getResponse().getContentAsString();
		assertEquals(expectedJson, actualJson);
	}

}
