package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assume.assumeTrue;

import org.junit.Assume.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.citiustech.code.BMI;
import com.citiustech.code.BMIException;
import com.citiustech.code.Person;

class BMITest4 {

	private String enviornment="dev";
	@Test
	void testIsDietingRecomendedShould_ReturnTrue() {
		// given
		assumeTrue(enviornment.equals("qa"));
		//assertTrue(enviornment.equals("qa"));

		Person p = new Person(80, 1.7);
		// when
		boolean recommended = BMI.isDietingRecomended(p);
		// then
		assertTrue(recommended);

	}

	@Test
	void testIsDietingRecomendedShould_Throwbmiexception() {
		// given
		Person p = new Person(0, 1.7);
		// when
		Executable e = () -> BMI.isDietingRecomended(p);
		// then
		assertThrows(BMIException.class, e);
	}

}
