package com.citiustech.test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.citiustech.code.BMI;
import com.citiustech.code.BMIException;
import com.citiustech.code.Person;

class BMITest {

	@Test
	void testIsDietingRecomendedShould_ReturnFalse() {
		// given
		Person p = new Person(70, 1.7);
		// when
		boolean recommended = BMI.isDietingRecomended(p);
		// then
		assertFalse(recommended);

	}

	@Test
	void testIsDietingRecomendedShould_ReturnTrue() {
		// given
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

	// Todo : write test case for calculateBMI method
	@Test
	void testCalculateExpectedBMI() {
		// given

		Person p = new Person(70, 1.7);
		// when
		double bmi = BMI.calculateBmi(p);
		double bmitest = 24;
		// then
		assertEquals(bmi, bmitest);
	}

	@Test
	void testCalculateunExpectedBMI() {
		// given

		Person p = new Person(70, 1.7);
		// when
		double bmi = BMI.calculateBmi(p);
		// then
		double bmitest = 28;
		assertNotEquals(bmi, bmitest);
	}

	@Test
	void TestingMultipleAsserts() {

		Person p = new Person(70, 1.7);
		assertEquals(70, p.getWeight());
		assertEquals(1.7, p.getHeight());
		//assertEquals(25, BMI.calculateBmi(p));

		/*
		 * assertAll(
		 *  ()-> assertEquals(70, p.getWeight()) ,
		 *   ()-> assertEquals(1.7,p.getHeight()) ,
		 *  ()-> assertEquals(25, BMI.calculateBmi(p))
		 * 
		 * 
		 * );
		 */}
	
	@Test
	void personwithLowestBMIshouldreturn_Exceptedvalue() {
		//given
		
		
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(70,1.7));
		persons.add(new Person(90,1.7));
		persons.add(new Person(120,1.7));
		
		//when
		Person actual=BMI.findPersonWithLowestBMI(persons);
		Person excepted=persons.get(0);
		//then
		assertEquals(actual, excepted);
	}
	
	@Test
	void getBMIValues_shouldreturn_Exceptedvalue() {
		//given
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(70,1.7));
		persons.add(new Person(90,1.7));
		persons.add(new Person(120,1.7));
		
		//when
		double[] actual=BMI.getBMIValues(persons);
		//then
		double[] excepted= {24,31,42};
		assertArrayEquals(excepted, actual);
	}
}
