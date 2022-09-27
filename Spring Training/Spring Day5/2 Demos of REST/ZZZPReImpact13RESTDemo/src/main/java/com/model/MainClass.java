package com.model;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainClass {

	public static void main(String[] args) {
		ObjectMapper mapper= new ObjectMapper();
		
		try {
			Student student= mapper.readValue(new File("data/Student-Info.json"), Student.class);
			System.out.println("ID ="+student.getId());
			System.out.println("FName="+student.getFirst_name());
			System.out.println("LName="+student.getLast_name());
			System.out.println("City ="+student.getAddress().getCity());
			System.out.println("State "+student.getAddress().getState());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 

	}

}
