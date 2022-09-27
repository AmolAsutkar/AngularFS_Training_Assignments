package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.citiustech.code.Calculator;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator c=new Calculator();
		int actualValue=c.add(10, 20);
		int exceptedValue=30;
		assertEquals(actualValue, exceptedValue);
	}
	
	/*
	 * @Test void testAddbadversion() { Calculator c=new Calculator(); int
	 * Result=c.add(10, 20); //no println should be there in testcases
	 * System.out.println(Result); }
	 */

	@Test
	public void testSub() {
		Calculator c=new Calculator();
		int actualValue=c.sub(10, 20);
		int exceptedValue=-10;
		assertEquals(actualValue, exceptedValue);
	}

}
