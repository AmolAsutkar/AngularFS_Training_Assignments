package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import com.citiustech.code.BMI;

class BMITest3 {

	@ParameterizedTest
	@CsvSource({"70,1.7,24", "90,1.7,31","120,1.7,42"})
	
	void CalcutateBMI_ShouldReturn_ExceptedValue(double weight,double height,double excepted) {
		
		double actual=BMI.calculateBmi(height, weight);
		
			
		assertEquals(actual, excepted);

	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/bmi.csv",numLinesToSkip = 1)
    void CalcutateBMIfromCSV_ShouldReturn_ExceptedValue(double weight,double height,double excepted) {
		
		double actual=BMI.calculateBmi(height, weight);
		
			
		assertEquals(actual, excepted);

	}
	
	@ParameterizedTest
    @MethodSource("bmiarguments")
void CalcutateBMIfromSomeinput_ShouldReturn_ExceptedValue(double weight,double height,double excepted) {
		
		double actual=BMI.calculateBmi(height, weight);
		
			
		assertEquals(actual, excepted);

	}
	
	private static Stream<Arguments> bmiarguments(){
		return Stream.of(
				Arguments.of(70,1.7,24),
				Arguments.of(90,1.7,31),
				Arguments.of(120,1.7,42)

				);
				
	}

}
