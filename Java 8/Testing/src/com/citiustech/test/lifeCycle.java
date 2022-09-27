package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class lifeCycle {

	@BeforeAll
	public static void beforeAll() {
		System.out.println("before all test cases");
	}
	@AfterAll
    public static void afterAll() {
		System.out.println("after all test cases");

    }
	@BeforeEach
    public  void beforeEach() {
		System.out.println("before each test cases");

    }
	
	@Test
	@DisplayName("my test case 1")
	@Order(1)
	public void xyz() {
		System.out.println("test case 1");
	}
	
	@Test
	@DisplayName("my test case 2")
	@Order(2)

	public void abc() {
		System.out.println("test case 2");
	}
}
