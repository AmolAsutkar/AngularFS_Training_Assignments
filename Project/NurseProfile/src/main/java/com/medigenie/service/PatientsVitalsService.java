package com.medigenie.service;

import java.util.List;

import com.medigenie.model.Appoinment;
import com.medigenie.model.PatientVitals;

public interface PatientsVitalsService {
	   public void AddPatientvitals(PatientVitals patientvitals);
	   public List<PatientVitals> fetchAllVitals();

}
