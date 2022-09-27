package com.citiustech.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.citiustech.entity.Complaint;
import com.opencsv.bean.CsvToBeanBuilder;

public class Main {

	public static void main(String[] args) {

		String fileName = "src\\complaints.csv";

        List<Complaint> beans = null;
		try {
			beans = new CsvToBeanBuilder(new FileReader(fileName))
			        .withType(Complaint.class)
			        .build()
			        .parse();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

        beans.forEach(System.out::println);

	}

}
