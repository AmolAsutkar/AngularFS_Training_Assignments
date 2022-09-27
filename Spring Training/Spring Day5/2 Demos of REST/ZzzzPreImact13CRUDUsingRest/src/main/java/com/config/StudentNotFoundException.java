package com.config;

public class StudentNotFoundException extends RuntimeException {
	StudentNotFoundException(String message){
		super(message);
	}

}
