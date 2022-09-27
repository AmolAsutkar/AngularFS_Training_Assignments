package com.citiustech.payload.response;

import javax.validation.constraints.NotBlank;

import com.citiustech.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NotBlank
public class JwtResponse {
	private String accessToken;
	private String type = "Bearer";
	private UserDTO user;
	
	public JwtResponse(String accessToken, UserDTO user) {
		this.accessToken = accessToken;
		this.user = user;
	}
}
