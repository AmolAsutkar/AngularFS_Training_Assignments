package com.citiustech.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.citiustech.constant.UserConstants;
import com.citiustech.dto.UserDTO;
import com.citiustech.enums.ERole;
import com.citiustech.enums.Status;
import com.citiustech.exception.UserException;
import com.citiustech.model.Role;
import com.citiustech.model.User;
import com.citiustech.payload.request.ChangeForgotPasswordRequest;
import com.citiustech.payload.request.ChangePasswordRequest;
import com.citiustech.payload.request.ForgotPasswordRequest;
import com.citiustech.payload.request.LoginRequest;
import com.citiustech.payload.request.RegisterRequest;
import com.citiustech.repository.RoleRepository;
import com.citiustech.repository.UserRepository;
import com.citiustech.security.jwt.JwtUtils;
import com.citiustech.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private EmailSenderService mailService;

	@Override
	public void save(UserDTO userDTO) {
		User user = new User();
		//User user=new User(null);
		if (userDTO != null) {
			BeanUtils.copyProperties(userDTO, user);
			userRepository.save(user);
		} else {
			throw new UserException(UserConstants.SAVE_FAILURE);
		}
	}

	@Override
	public UserDTO findById(long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			Set<Role> roles = userRepository.findById(id).get().getRoles();
			UserDTO userDTO = new UserDTO();
			userDTO.setRoles(roles);
			BeanUtils.copyProperties(optionalUser.get(), userDTO);
			return userDTO;
		} else {
			throw new UserException(UserConstants.USER_FETCHED_FAILURE);
		}

	}

	@Override
	public UserDTO findByIdAndStatus(long id, Status status) {
		Optional<User> optionalUser = userRepository.findByIdAndStatus(id, status);
		if (optionalUser.isPresent()) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(optionalUser.get(), userDTO);
			return userDTO;
		} else {
			throw new UserException(UserConstants.USER_FETCHED_FAILURE);
		}

	}

	@Override
	public UserDTO findByEmailAndStatus(String email, Status status) {
		Optional<User> optionalUser = userRepository.findByEmailAndStatus(email, status);
		if (optionalUser.isPresent()) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(optionalUser.get(), userDTO);
			return userDTO;
		} else {
			throw new UserException(UserConstants.USER_FETCHED_FAILURE);
		}
	}

	public Boolean existsByEmail(String email) {
		if (findByEmail(email) != null) {
			return true;
		}
		return false;
	}

	@Override
	public UserDTO findByEmail(String email) {
		Optional<User> optionalUser = userRepository.findByEmail(email);
		if (optionalUser.isPresent()) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(optionalUser.get(), userDTO);
			return userDTO;
		} else {
			throw new UserException(UserConstants.USER_FETCHED_FAILURE);
		}
	}

	@Override
	public List<UserDTO> findAll() {
		List<User> users = userRepository.findAll();
		List<UserDTO> userDTOS = new ArrayList<>();
		if (!users.isEmpty()) {
			users.forEach(e -> {
				UserDTO userDTO = new UserDTO();
				BeanUtils.copyProperties(e, userDTO);
				userDTOS.add(userDTO);
			});
			return userDTOS;
		} else {
			throw new UserException(UserConstants.USER_FETCHED_FAILURE);
		}

	}

	@Override
	public List<UserDTO> findAllByStatus(Status status) {
		List<User> users = userRepository.findAllByStatus(status);
		List<UserDTO> userDTOS = new ArrayList<>();
		if (!users.isEmpty()) {
			users.forEach(e -> {
				UserDTO userDTO = new UserDTO();
				BeanUtils.copyProperties(e, userDTO);
				userDTOS.add(userDTO);
			});
			return userDTOS;
		} else {
			throw new UserException(UserConstants.USER_FETCHED_FAILURE);
		}
	}

	@Override
	public void deleteUserById(long id) {
		UserDTO userDTO = this.findById(id);
		if (userDTO != null) {
			User user = new User();
			BeanUtils.copyProperties(userDTO, user);
			user.setStatus(Status.DEACTIVATE);
			userRepository.save(user);
		} else {
			throw new UserException(UserConstants.USER_FETCHED_FAILURE);
		}
	}

	@Override
	public void changeStatus(long id) {
		User user = userRepository.findById(id).get();
		if (user.getStatus() == Status.ACTIVE) {
			user.setStatus(Status.DEACTIVATE);
			userRepository.save(user);
		} else {
			user.setStatus(Status.ACTIVE);
			user.setWrongAttempt(0);
			userRepository.save(user);
		}
	}

	@Override
	public void changePassword(ChangePasswordRequest request) {

		User user = userRepository.findByEmail(request.getEmail()).get();

		passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = user.getPassword();

		if (passwordEncoder.matches(request.getOldPassword(), encodedPassword)) {
			user.setPassword(passwordEncoder.encode(request.getNewPassword()));
			user.setFirstLogin(false);
			userRepository.save(user);

		} else {
			throw new UserException(UserConstants.USER_FETCHED_FAILURE);
		}

	}
	

	public UserDTO forgotPassword(ForgotPasswordRequest request) {
		System.out.println("inside forgot password method");
		User user = userRepository.findByEmail(request.getEmail()).get();
		
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(user, userDTO);
		
		return userDTO;

	//	mailService.sendSimpleEmail(user.getEmail(), "http://localhost:4200/changePassword",
	//			"CTZen Hospital");
	}

	@Override
	public void changeForgotPassword(ChangeForgotPasswordRequest request) {
		User user = userRepository.findByEmail(request.getEmail()).get();
		passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(request.getNewPassword());
		user.setPassword(passwordEncoder.encode(request.getNewPassword()));
		userRepository.save(user);
	}

	@Override
	public UserDTO signup(RegisterRequest registerRequest) {

		if (userRepository.existsByEmail(registerRequest.getEmail())) {
			throw new UserException(UserConstants.USER_EXISTED);
		} else if (userRepository.existsByMobileNumber(registerRequest.getMobileNumber())) {
			throw new UserException(UserConstants.USER_EXISTED);
		}
		
		if(registerRequest.getPassword() == null) {
			registerRequest.setPassword("Password@123");
		}

		User user = new User(registerRequest.getEmail(), passwordEncoder.encode(registerRequest.getPassword()),
				registerRequest.getFirstName(), registerRequest.getLastName(), registerRequest.getDateOfBirth(),
			 registerRequest.getTitle(),registerRequest.getMobileNumber(), Status.ACTIVE, registerRequest.getGender());
		
		UserDTO userDTO = new UserDTO();
			String strRole = registerRequest.getRole();
			Set<String> strRoles = new HashSet<>();
			strRoles.add(strRole);
			Set<Role> roles = new HashSet<>();

			if (strRole == null) {
				Role userRole = roleRepository.findByRole(ERole.ROLE_PATIENT)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(userRole);
				user.setFirstLogin(false);

				//mailService.sendSimpleEmail(user.getEmail(), "Thanks for your registration",
				//		"CTZen Hospital");

			} else {
				strRoles.forEach(role -> {
					switch (role) {
					case "ROLE_ADMIN":
						Role adminRole = roleRepository.findByRole(ERole.ROLE_ADMIN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(adminRole);
						break;

					case "ROLE_PHYSICIAN":
						Role physicianRole = roleRepository.findByRole(ERole.ROLE_PHYSICIAN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(physicianRole);
						//mailService.sendSimpleEmail(user.getEmail(), "Your default password is Password@123",
						//		"CTZen Hospital");
						break;

					default:
						Role userRole = roleRepository.findByRole(ERole.ROLE_NURSE)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(userRole);
						mailService.sendSimpleEmail(user.getEmail(), "Your default password is Password@123",
								"CTZen Hospital");
					}
				});
			}

			user.setRoles(roles);
			BeanUtils.copyProperties(user, userDTO);
			userRepository.save(user);
		return userDTO;

	}

	@Override
	public String signin(LoginRequest loginRequest) {
		User user = userRepository.findByEmail(loginRequest.getEmail()).get();
		
		if(user == null) {
			throw new UserException(UserConstants.INVALID_USER);
		}
		
		System.out.println(user.getStatus());
		if (user.getStatus() == Status.DEACTIVATE) {
			throw new UserException(UserConstants.DEACTIVATED_USER);
		} else if (user.getStatus() == Status.BLOCKED) {
			throw new UserException(UserConstants.ERROR);
		}

		passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = user.getPassword();

		if (user.getWrongAttempt() < 3) {
			if (passwordEncoder.matches(loginRequest.getPassword(), encodedPassword)) {
				Authentication authentication = authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
				
				System.out.println(authentication);

				SecurityContextHolder.getContext().setAuthentication(authentication);
				String jwt = jwtUtils.generateJwtToken(authentication);

				return jwt;
			} else {
				int value = user.getWrongAttempt();
				user.setWrongAttempt(value + 1);
				userRepository.save(user);
				throw new UserException(UserConstants.INVALID_USER);
			}
		} else {

			user.setStatus(Status.DEACTIVATE);
			userRepository.save(user);
			throw new UserException(UserConstants.DEACTIVATED_USER);
		}

	}

	@Override
	public List<User> findAllUsers(String role) {
		List<User> users = userRepository.findAll();
		List<User> result = new ArrayList<>();

		users.stream().forEach(user -> {
			System.out.println(user.getRoles());
			if (role.equals("ADMIN")) {
				Set<Role> userRoles = user.getRoles();
				userRoles.stream().forEach(userRole -> {
					if (userRole.getRole() == ERole.ROLE_ADMIN) {
						result.add(user);
					}
				});

			} else if (role.equals("PHYSICIAN")) {
				Set<Role> userRoles = user.getRoles();
				userRoles.stream().forEach(userRole -> {
					if (userRole.getRole() == ERole.ROLE_PHYSICIAN) {
						result.add(user);
					}
				});
			} else if (role.equals("NURSE")) {
				Set<Role> userRoles = user.getRoles();
				userRoles.stream().forEach(userRole -> {
					if (userRole.getRole() == ERole.ROLE_NURSE) {
						result.add(user);
					}
				});
			} else {
				Set<Role> userRoles = user.getRoles();
				userRoles.stream().forEach(userRole -> {
					if (userRole.getRole() == ERole.ROLE_PATIENT) {
						result.add(user);
					}
				});
			}
		});

		return result;
	}

}
