package com.citiustech.service;

import java.util.List;

import com.citiustech.dto.UserDTO;
import com.citiustech.enums.Status;
import com.citiustech.model.User;
import com.citiustech.payload.request.ChangeForgotPasswordRequest;
import com.citiustech.payload.request.ChangePasswordRequest;
import com.citiustech.payload.request.ForgotPasswordRequest;
import com.citiustech.payload.request.LoginRequest;
import com.citiustech.payload.request.RegisterRequest;

public interface UserService {

	void save(UserDTO userDTO);

	UserDTO findById(long id);

	UserDTO findByIdAndStatus(long id, Status status);

	UserDTO findByEmailAndStatus(String email, Status status);

	UserDTO findByEmail(String email);

	List<UserDTO> findAll();

	List<UserDTO> findAllByStatus(Status status);
	
//	List<UserDTO> findAllByRole(ERole role);

	void deleteUserById(long id);
	
	void changePassword(ChangePasswordRequest request);
	
	UserDTO signup(RegisterRequest registerRequest);
	String signin(LoginRequest loginRequest);
	
	void changeStatus(long id);
	
	List<User> findAllUsers(String role);
	
	UserDTO forgotPassword(ForgotPasswordRequest request);
	
	void changeForgotPassword(ChangeForgotPasswordRequest request);

}
