package com.citiustech.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BMI {

public static double calculateBmi(Person p) {
double height=p.getHeight();
double weight=p.getWeight();

if(height<=0 || weight <=0)
	throw new BMIException("incorrect data");


double bmi=weight/(height*height);
return Math.round(bmi);
	}

public static double calculateBmi(double height,double weight) {


if(height<=0 || weight <=0)
	throw new BMIException("incorrect data");


double bmi=weight/(height*height);
return Math.round(bmi);
	}

	
public static boolean isDietingRecomended(Person p) {
	double bmi=calculateBmi(p);
	if(bmi<25)
		return false;
return true;
}

public static Person findPersonWithLowestBMI(List<Person> persons) {
	
	
	
	if(!persons.isEmpty()) {
		return persons.stream().min(Comparator.comparing(BMI::calculateBmi)).get();
		
		 }
	
	
	else {
		throw new BMIException("Person list cannot be empty");
		}
	
	
}
public static double[] getBMIValues(List<Person> persons) {
	
	//double[] bmis = persons.stream().mapToDouble(BMI::calculateBmi).toArray();
	//return bmis;
	return persons.stream().mapToDouble(BMI::calculateBmi).toArray();
}
}


