package com.medigenie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medigenie.model.PatientVitals;

@Repository
public interface PatientVitalRepo extends JpaRepository<PatientVitals, Long> {

}
