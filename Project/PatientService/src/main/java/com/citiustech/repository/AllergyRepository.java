package com.citiustech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citiustech.model.Allergy;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, Long>{
	
	@Query("select a from Allergy a where a.AllergyType= :AllergyType")
	List<Allergy> findByAllergyType(String AllergyType);
	
	List<Allergy> findAllergyByPatientsId(Long patientId);

}
