package com.medigenie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medigenie.model.PatientVitals;
import com.medigenie.repository.PatientVitalRepo;

@Service
public class PatientsVitalsServiceImpl  implements PatientsVitalsService{
	
	@Autowired
	PatientVitalRepo patientvitalrepo;
	

	@Override
	public void AddPatientvitals(PatientVitals patientvitals) {
		patientvitalrepo.save(patientvitals);
	}

	@Override
	public List<PatientVitals> fetchAllVitals() {
		List<PatientVitals> patientVitalsList= patientvitalrepo.findAll();
		return patientVitalsList;
	}

}
