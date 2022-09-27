package com.assign1.repo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.assign1.entity.Complaints;
import com.opencsv.bean.CsvToBeanBuilder;

public class Repo {
	
	public static List<Complaints> getCsvFile() {
		String fileName = "src\\test\\resources\\complaints.csv";
		List<Complaints> beans = null;
		
        try {
			beans = new CsvToBeanBuilder(new FileReader(fileName))
			        .withType(Complaints.class)
			        .build()
			        .parse();
		} catch (IllegalStateException e) {
			System.out.println("Error parsing the file!");
		} catch (FileNotFoundException e) {
			System.out.println("Error parsing the file!");
		}
        
        return beans;

	}

}
