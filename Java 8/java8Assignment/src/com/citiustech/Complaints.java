package com.citiustech;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvToBeanBuilder;


public class Complaints {

	public static List<ComplaintPojo> getCsvFile() {
		String fileName = "complaints.csv";
		List<ComplaintPojo> cmpojo = null;
		
        try {
        	cmpojo = new CsvToBeanBuilder(new FileReader(fileName))
			        .withType(ComplaintPojo.class)
			        .build()
			        .parse();
		} catch (IllegalStateException e) {
			System.out.println("Error parsing the file!");
		} catch (FileNotFoundException e) {
			System.out.println("Error parsing the file!");
		}
        
        return cmpojo;
	}
}
