package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;

import com.citiustech.code.Calculator;

class CalculatorTest2 {

	@Rule
	public Timeout timeout = Timeout.seconds(1);
	
	@Rule
	private TestName testtime = new TestName();
	@Test
	void testAdd() {
		System.out.println(testtime.getMethodName());
		Calculator c=new Calculator();
		int actualValue=c.add(10, 20);
		int exceptedValue=30;
		assertEquals(actualValue, exceptedValue);
	}
	
	@Test
	void testAdd2() {
		System.out.println(testtime.getMethodName());

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
	void testSub() {
		Calculator c=new Calculator();
		int actualValue=c.sub(10, 20);
		int exceptedValue=-10;
		assertEquals(actualValue, exceptedValue);
	}
}
