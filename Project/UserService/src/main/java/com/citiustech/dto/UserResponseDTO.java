package com.citiustech.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResponseDTO {

    private HttpStatus status;
    public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public UserResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserResponseDTO(HttpStatus status, String message, UserDTO data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserDTO getData() {
		return data;
	}
	public void setData(UserDTO data) {
		this.data = data;
	}
	private String message;
    private UserDTO data;
}
