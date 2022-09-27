package com.citiustech.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.citiustech.constant.UserConstants;
import com.citiustech.dto.UserResponseDTO;
import com.citiustech.exception.UserException;

@ControllerAdvice
public class UserControllerAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler(UserException.class)
    public ResponseEntity<UserResponseDTO> handleUserFailure(UserException exception, WebRequest webRequest) {

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setStatus(HttpStatus.BAD_REQUEST);
        userResponseDTO.setMessage(exception.getMessage());

        return new ResponseEntity<>(userResponseDTO,userResponseDTO.getStatus());

    }


    @ExceptionHandler({HttpClientErrorException.class, HttpServerErrorException.class})
    public ResponseEntity<UserResponseDTO> handleUserServiceNotAvailable(RuntimeException e, WebRequest webRequest) {

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setStatus(HttpStatus.BAD_REQUEST);
        userResponseDTO.setMessage(e.getMessage());

        return new ResponseEntity<>(userResponseDTO,userResponseDTO.getStatus());

    }
    
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<UserResponseDTO> handleUserLoginFailure(RuntimeException e, WebRequest webRequest) {

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setStatus(HttpStatus.BAD_REQUEST);
        userResponseDTO.setMessage(UserConstants.INVALID_USER);

        return new ResponseEntity<>(userResponseDTO,userResponseDTO.getStatus());

    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<UserResponseDTO> handleUserOtherFailure(RuntimeException e, WebRequest webRequest) {

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        userResponseDTO.setMessage(UserConstants.INVALID_USER);

        return new ResponseEntity<>(userResponseDTO,userResponseDTO.getStatus());

    }
}
