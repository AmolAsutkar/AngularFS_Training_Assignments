package com.citiustech.security.services;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.citiustech.enums.Status;
import com.citiustech.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private long id;

	private String firstName;

	private String lastName;

	private Date dateOfBirth;

	private String title;
	
	private Collection<? extends GrantedAuthority> authorities;
 
	private Status status;

	private String email;
	@JsonIgnore
	private String password;
	private String employeeID;
	private String mobileNumber;
	
	public UserDetailsImpl(Long id, String firstName, String lastName, Date dateOfBirth,
			String title, Status status, String email, String password, String employeeID, 
			String mobileNumber, Collection<? extends GrantedAuthority> authorities) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.title = title;
		this.status = status;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
		this.employeeID = employeeID;
		this.mobileNumber = mobileNumber;
	}
	
	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRole().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getId(), 
				user.getFirstName(), 
				user.getLastName(),
				user.getDateOfBirth(),
				user.getTitle(),
				user.getStatus(),
				user.getEmail(),
				user.getPassword(),
				user.getEmployeeID(),
				user.getMobileNumber(),
				authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	public UserDetailsImpl(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return status;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getTitle() {
		return title;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
