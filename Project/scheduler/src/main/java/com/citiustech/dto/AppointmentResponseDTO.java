package com.citiustech.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponseDTO {

	private HttpStatus status;
    private String message;
    private AppointmentDTO data;
    
	public AppointmentResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppointmentResponseDTO(HttpStatus status, String message, AppointmentDTO data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public AppointmentDTO getData() {
		return data;
	}
	public void setData(AppointmentDTO data) {
		this.data = data;
	}
    
	
    
}
