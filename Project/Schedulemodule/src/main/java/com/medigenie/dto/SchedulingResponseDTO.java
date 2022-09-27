package com.medigenie.dto;

import org.springframework.http.HttpStatus;

public class SchedulingResponseDTO {

    
	private HttpStatus status;
	private String message;
 
	
	public SchedulingResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SchedulingResponseDTO(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
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
	
}
