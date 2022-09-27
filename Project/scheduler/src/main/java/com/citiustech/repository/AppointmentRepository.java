package com.citiustech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citiustech.enums.AppointmentStatus;
import com.citiustech.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	//@Query("select a from Appointment a where a.userId=:userId and a.status=:status")

	@Query("select a from Appointment a where a.userId=:userId")
	List<Appointment> findAllByUserIdAndStatus(long userId);
	//List<Appointment> findAllByUserIdAndStatus(long userId, AppointmentStatus status);


	//@Query("select a from Appointment a where a.physicianId=:physicianId and a.status=:status")
	//List<Appointment> findAllByPhysicianIdAndStatus(long physicianId, AppointmentStatus status);
	
	@Query("select a from Appointment a where a.physicianId=:physicianId")
	List<Appointment> findAllByPhysicianIdAndStatus(long physicianId);
	
	Appointment findById(long id);
}
