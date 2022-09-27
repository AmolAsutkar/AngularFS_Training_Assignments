package com.citiustech.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.citiustech.constants.AppointmentConstants;
import com.citiustech.dto.AppointmentResponseDTO;
import com.citiustech.exception.AppointmentException;

public class AppointmentControllerAdvice {

	@ExceptionHandler(AppointmentException.class)
	public ResponseEntity<AppointmentResponseDTO> handleUserFailure(AppointmentException exception,
			WebRequest webRequest) {

		AppointmentResponseDTO responseDTO = new AppointmentResponseDTO();
		responseDTO.setStatus(HttpStatus.BAD_REQUEST);
		responseDTO.setMessage(exception.getMessage());

		return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<AppointmentResponseDTO> handleUserOtherFailure(RuntimeException e, WebRequest webRequest) {

		AppointmentResponseDTO responseDTO = new AppointmentResponseDTO();
		responseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<>(responseDTO, responseDTO.getStatus());

	}
	
}
