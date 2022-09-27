package com.medigenie.user.controller;


import com.medigenie.user.constant.UserConstants;
import com.medigenie.user.dto.UserResponseDTO;
import com.medigenie.user.exception.UserException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler(UserException.class)
    public ResponseEntity<UserResponseDTO> handleUserFailure(UserException exception, WebRequest webRequest) {

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setStatus(HttpStatus.BAD_REQUEST);
        userResponseDTO.setMessage(exception.getMessage());

        return new ResponseEntity<>(userResponseDTO,userResponseDTO.getStatus());

    }


    @ExceptionHandler({CallNotPermittedException.class, HttpClientErrorException.class, HttpServerErrorException.class})
    public ResponseEntity<UserResponseDTO> handleUserServiceNotAvailable(RuntimeException e, WebRequest webRequest) {

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setStatus(HttpStatus.BAD_REQUEST);
        userResponseDTO.setMessage(e.getMessage());

        return new ResponseEntity<>(userResponseDTO,userResponseDTO.getStatus());

    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<UserResponseDTO> handleUserOtherFailure(RuntimeException e, WebRequest webRequest) {

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        userResponseDTO.setMessage(UserConstants.SERVICE_DOWN);

        return new ResponseEntity<>(userResponseDTO,userResponseDTO.getStatus());

    }
}
