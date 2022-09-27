package com.citiustech.request;

import lombok.Data;

@Data
public class ChangeStatusRequest {

	private long id;
	private String status;
	
	public ChangeStatusRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChangeStatusRequest(long id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
