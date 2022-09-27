package com.citiustech.dto;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.citiustech.enums.Status;
import com.citiustech.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Long id;
	private String title;
    private String firstName;
    public Long getId() {
		return id;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO(Long id, String title, String firstName, String lastName, Date dateOfBirth, Status status,
			String email, Set<Role> roles, String employeeID, String mobileNumber, int wrongAttempt,
			boolean isFirstLogin, boolean isForgotpassword, String gender, String specialization) {
		super();
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.status = status;
		this.email = email;
		this.roles = roles;
		this.employeeID = employeeID;
		this.mobileNumber = mobileNumber;
		this.wrongAttempt = wrongAttempt;
		this.isFirstLogin = isFirstLogin;
		this.isForgotpassword = isForgotpassword;
		this.gender = gender;
		this.specialization = specialization;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getWrongAttempt() {
		return wrongAttempt;
	}
	public void setWrongAttempt(int wrongAttempt) {
		this.wrongAttempt = wrongAttempt;
	}
	public boolean isFirstLogin() {
		return isFirstLogin;
	}
	public void setFirstLogin(boolean isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}
	public boolean isForgotpassword() {
		return isForgotpassword;
	}
	public void setForgotpassword(boolean isForgotpassword) {
		this.isForgotpassword = isForgotpassword;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	private String lastName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;
    private Status status;
    private String email;
    private Set<Role> roles;
    private String employeeID;
    private String mobileNumber;
    private int wrongAttempt;
    private boolean isFirstLogin;
	private boolean isForgotpassword;
	private String gender;
	private String specialization;

}
