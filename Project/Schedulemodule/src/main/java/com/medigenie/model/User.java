package com.medigenie.model;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name = "tbl_users")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name = "title")
	private String title;
	
	//@ManyToMany(fetch = FetchType.EAGER)
	//@Fetch(value = FetchMode.SUBSELECT)
	//@JoinTable(name = "user_roles",
	//			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
	//			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
	//			)
	//private Set<Role> roles = new HashSet<>();
 
	//@Enumerated(EnumType.STRING)
	//private Status status;

	private String email;
	private String password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long id, String firstName, String lastName, Date dateOfBirth, String title, String email,
			String password, String employeeID, String mobileNumber, int wrongAttempt, boolean isFirstLogin,
			String forgotPasswordOTP, Date createdAt, String specialization, String gender,
			LocalDate passwordExpiryDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.title = title;
		this.email = email;
		this.password = password;
		this.employeeID = employeeID;
		this.mobileNumber = mobileNumber;
		this.wrongAttempt = wrongAttempt;
		this.isFirstLogin = isFirstLogin;
		this.forgotPasswordOTP = forgotPasswordOTP;
		this.createdAt = createdAt;
		this.specialization = specialization;
		this.gender = gender;
		this.passwordExpiryDate = passwordExpiryDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getForgotPasswordOTP() {
		return forgotPasswordOTP;
	}

	public void setForgotPasswordOTP(String forgotPasswordOTP) {
		this.forgotPasswordOTP = forgotPasswordOTP;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getPasswordExpiryDate() {
		return passwordExpiryDate;
	}

	public void setPasswordExpiryDate(LocalDate passwordExpiryDate) {
		this.passwordExpiryDate = passwordExpiryDate;
	}

	@Column(name = "employee_id")
	private String employeeID;
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	private int wrongAttempt;
	private boolean isFirstLogin = true;
	private String forgotPasswordOTP;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;
	
	private String specialization;
	private String gender;
	
	 @Column(name = "password_expiry_date")
	private LocalDate passwordExpiryDate;
	

}
