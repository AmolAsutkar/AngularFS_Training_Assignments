package com.citiustech.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.Test;

import com.citiustech.code.Calculator;

public class CalculatortTest {
	
	//@DI
	private Calculator c;
	
	@Rule
	public DIRule rule  = new DIRule();
	@Test
	void testAdd() {
		
		int actualValue=c.add(10, 20);
		int exceptedValue=30;
		assertEquals(actualValue, exceptedValue);
	}

}
