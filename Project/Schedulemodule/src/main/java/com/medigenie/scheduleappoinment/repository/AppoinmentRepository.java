package com.medigenie.scheduleappoinment.repository;

import org.springframework.stereotype.Repository;

import com.medigenie.model.Appoinment;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface AppoinmentRepository extends JpaRepository<Appoinment,Long>{

	@Query(value = "select description from Appoinment where appoinment_date >= CONVERT(date, SYSDATETIME())")
	List<Appoinment> findAllfuturedate();

	
	

}
