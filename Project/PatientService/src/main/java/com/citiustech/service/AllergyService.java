package com.citiustech.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.citiustech.helper.ExcelHelper;
import com.citiustech.model.Allergy;
import com.citiustech.repository.AllergyRepository;

@Service
public class AllergyService {

	@Autowired
	AllergyRepository allergyRepository;
	
	public void save(MultipartFile file) {
	    try {
	      List<Allergy> tutorials = ExcelHelper.excelToAllergy(file.getInputStream());
	      allergyRepository.saveAll(tutorials);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }
	
	public List<Allergy> getAllAllergy() {
	    return allergyRepository.findAll();
	  }
	
	public List<Allergy> getAllergyByType(String AllergyType){
		 return allergyRepository.findByAllergyType(AllergyType);
	}
	
	
}
