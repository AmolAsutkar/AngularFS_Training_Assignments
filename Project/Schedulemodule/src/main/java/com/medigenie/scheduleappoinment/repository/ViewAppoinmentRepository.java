package com.medigenie.scheduleappoinment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medigenie.model.Physican;

@Repository
public interface ViewAppoinmentRepository extends JpaRepository<Physican, Long>{

}
