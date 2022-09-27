package com.citiustech.fileparser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.citiustech.entity.Complaint;
import com.opencsv.bean.CsvToBeanBuilder;

public class CsvLoader {

public static void main(String[] args) {
	String fileName = "src\\test\\resources\\complaints.csv";

    List<Complaint> comp = null;
	try {
		comp = new CsvToBeanBuilder(new FileReader(fileName))
		        .withType(Complaint.class)
		        .build()
		        .parse();
	} catch (IllegalStateException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}

	comp.forEach(System.out::println);
	//return comp;

}


	public List<Complaint> loadFile() {

		String fileName = "src\\test\\resources\\complaints.csv";

        List<Complaint> comp = null;
		try {
			comp = new CsvToBeanBuilder(new FileReader(fileName))
			        .withType(Complaint.class)
			        .build()
			        .parse();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		comp.forEach(System.out::println);
		return comp;

	}
	}
