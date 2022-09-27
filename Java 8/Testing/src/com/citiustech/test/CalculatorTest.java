package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import com.citiustech.code.Calculator;

class CalculatorTest {

	@Test
	void testAdd() {
		Calculator c=new Calculator();
		int actualValue=c.add(10, 20);
		int exceptedValue=30;
		assertEquals(actualValue, exceptedValue);
	}
	
	@Test
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	void testAddV2() {
		Calculator c = new Calculator();
		int actualValue = c.add(10, 20);
		int expectedValue = 30;
		assertEquals(expectedValue, actualValue);
	}
	/*
	 * @Test void testAddbadversion() { Calculator c=new Calculator(); int
	 * Result=c.add(10, 20); //no println should be there in testcases
	 * System.out.println(Result); }
	 */

	@Test
	void testSub() {
		Calculator c=new Calculator();
		int actualValue=c.sub(10, 20);
		int exceptedValue=-10;
		assertEquals(actualValue, exceptedValue);
	}
}
