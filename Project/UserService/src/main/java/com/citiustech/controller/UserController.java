package com.citiustech.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.constant.UserConstants;
import com.citiustech.dto.UserDTO;
import com.citiustech.dto.UserResponseDTO;
import com.citiustech.enums.Status;
import com.citiustech.model.User;
import com.citiustech.payload.request.ChangeForgotPasswordRequest;
import com.citiustech.payload.request.ChangePasswordRequest;
import com.citiustech.payload.request.ForgotPasswordRequest;
import com.citiustech.payload.request.LoginRequest;
import com.citiustech.payload.request.RegisterRequest;
import com.citiustech.payload.response.JwtResponse;
import com.citiustech.payload.response.MessageResponse;
import com.citiustech.repository.RoleRepository;
import com.citiustech.repository.UserRepository;
import com.citiustech.security.jwt.JwtUtils;
import com.citiustech.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userService;
		
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	 BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/findById/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('PHYSICIAN') or hasRole('NURSE')")
	public ResponseEntity<UserDTO> findById(@PathVariable(name = "id") long id) {
		UserDTO userDTO = userService.findById(id);
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
	
	@GetMapping("/findByStatus")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<UserDTO>> getUsersByStatus(@RequestParam Status status) {
		List<UserDTO> userDTO = userService.findAllByStatus(status);
		return new ResponseEntity<List<UserDTO>>(userDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/changeStatus/{id}")
	public ResponseEntity<?> changeStatus(@PathVariable(name = "id") long id) {
		userService.changeStatus(id);
		return ResponseEntity.ok(new MessageResponse("User Status changed Successfully"));
	}
 	
	@PreAuthorize("hasRole('ADMIN') or hasRole('PHYSICIAN') or hasRole('NURSE') or hasRole('PATIENT')")
	@PutMapping("/changePassword")
	public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest request) {
		userService.changePassword(request);
		return ResponseEntity.ok(new MessageResponse("User Password changed successfully!"));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		UserDTO userDTO = userService.signup(registerRequest);
		
		userResponseDTO.setStatus(HttpStatus.OK);
		userResponseDTO.setMessage(UserConstants.SAVE_SUCCESS);
		userResponseDTO.setData(userDTO);

		return new ResponseEntity<>(userResponseDTO, userResponseDTO.getStatus());
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
		
		User user = userRepository.findByEmail(loginRequest.getEmail()).get();
		String jwt = userService.signin(loginRequest);
		
		UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDTO));
	}
	
	@GetMapping("/findByRole")
	@PreAuthorize("hasRole('ADMIN') or hasRole('PHYSICIAN') or hasRole('NURSE')")
	public ResponseEntity<List<User>> getUserByRole(@RequestParam(name = "role") String role) {
		List<User> userDTO = userService.findAllUsers(role);
		return new ResponseEntity<List<User>>(userDTO, HttpStatus.OK);
	}
	
	@PostMapping("/forgotPassword")
	public ResponseEntity<UserDTO> forgotPassword(@RequestBody ForgotPasswordRequest request) {
		UserDTO userDTO = userService.forgotPassword(request);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}
	
	@PostMapping("/changeForgotPassword")
	public ResponseEntity<?> changeForgotPassword(@RequestBody ChangeForgotPasswordRequest request) {
		userService.changeForgotPassword(request);
		return ResponseEntity.ok(new MessageResponse("Forgot password changed!"));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		
	//	User updateUser = new User(user);
		
		return null;
		
	}
}


















