package com.citiustech.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citiustech.enums.Status;
import com.citiustech.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
	
	Boolean existsByEmail(String email);
	Boolean existsByEmployeeID(String employeeID);
	Boolean existsByMobileNumber(String mobileNumber);
	
	Optional<User> findByIdAndStatus(long email, Status status);

	Optional<User> findByEmailAndStatus(String email, Status status);

	@Query("select u from User u where u.status= :status")
	List<User> findAllByStatus(Status status);
	
//	@Query("select u from User u join user_roles ur on u.id = ur.id"
//			+ "join Role r on ur.id = r.id where r.role  : role")
//	List<User> findAllByRole(ERole role);
	
}
