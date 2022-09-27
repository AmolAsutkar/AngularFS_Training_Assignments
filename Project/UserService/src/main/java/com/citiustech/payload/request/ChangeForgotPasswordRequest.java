package com.citiustech.payload.request;

import lombok.Data;

@Data
public class ChangeForgotPasswordRequest {
	
	private String email;
	private String newPassword;

	public ChangeForgotPasswordRequest(String email, String newPassword) {
		super();
		this.email = email;
		this.newPassword = newPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ChangeForgotPasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
}
