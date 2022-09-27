package com.citiustech.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.citiustech.model.Allergy;

public class ExcelHelper {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "AllergyID", "AllergyType", "AllergyName", "AllergenSource", "IsoformsOrPartialSequencesOfAllergen","Allerginicity"};
	  static String SHEET = "Allergy";
	  public static boolean hasExcelFormat(MultipartFile file) {
	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }
	    return true;
	  }
	  public static List<Allergy> excelToAllergy(InputStream is) {
	    try {
	      Workbook workbook = new XSSFWorkbook(is);
	      Sheet sheet = workbook.getSheet(SHEET);
	      Iterator<Row> rows = sheet.iterator();
	      List<Allergy> tutorials = new ArrayList<Allergy>();
	      int rowNumber = 0;
	      while (rows.hasNext()) {
	        Row currentRow = rows.next();
	        // skip header
	        if (rowNumber == 0) {
	          rowNumber++;
	          continue;
	        }
	        Iterator<Cell> cellsInRow = currentRow.iterator();
	        Allergy allergy = new Allergy();
	        int cellIdx = 0;
	        while (cellsInRow.hasNext()) {
	          Cell currentCell = cellsInRow.next();
	          switch (cellIdx) {
	          case 0:
	        	  allergy.setAllergyID(currentCell.getStringCellValue());
	            break;
	          case 1:
	        	  allergy.setAllergyType(currentCell.getStringCellValue());
	            break;
	          case 2:
	        	  allergy.setAllergyName(currentCell.getStringCellValue());
	            break;
	          case 3:
	        	  allergy.setAllergenSource(currentCell.getStringCellValue());
	            break;
	          case 4:
	        	  allergy.setIsoformsOrPartialSequencesOfAllergen(currentCell.getStringCellValue());
	            break;
	          case 5:
	        	  allergy.setAllerginicity(currentCell.getStringCellValue());
	            break;
	          default:
	            break;
	          }
	          cellIdx++;
	        }
	        tutorials.add(allergy);
	      }
	      workbook.close();
	      return tutorials;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }
	  }
	}

