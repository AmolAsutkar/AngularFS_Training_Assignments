package com.citiustech.exception;

public class AppointmentException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AppointmentException() {
        super();
    }

    public AppointmentException(String message) {
        super(message);
    }

    public AppointmentException(String message, Throwable cause) {
        super(message, cause);
    }
}
