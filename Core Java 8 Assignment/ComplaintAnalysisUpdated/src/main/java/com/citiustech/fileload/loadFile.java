package com.citiustech.fileload;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.citiustech.entity.Complaints;
import com.opencsv.bean.CsvToBeanBuilder;

public class loadFile {

	public  List<Complaints> loadCsvFile() {

		String fileName = "src\\test\\resources\\complaints.csv";

        List<Complaints> comp = null;
		try {
			comp = new CsvToBeanBuilder(new FileReader(fileName))
			        .withType(Complaints.class)
			        .build()
			        .parse();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//comp.forEach(System.out::println);
		return comp;

	}
}
