package com.model;

public class StudentErrorResponse {
	
	private int status_code;
	private String message;
	private long timestramp;
	public int getStatus_code() {
		return status_code;
	}
	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimestramp() {
		return timestramp;
	}
	public void setTimestramp(long timestramp) {
		this.timestramp = timestramp;
	}
	public StudentErrorResponse(int status_code, String message, long timestramp) {
		super();
		this.status_code = status_code;
		this.message = message;
		this.timestramp = timestramp;
	}
	public StudentErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "StudentErrorResponse [status_code=" + status_code + ", message=" + message + ", timestramp="
				+ timestramp + "]";
	}
	

}
