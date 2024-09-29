package com.sms.smsManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtpRequest {
	private String username;
    private String phoneNumber;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public OtpRequest() {
		super();
	}
	public OtpRequest(String username, String phoneNumber) {
		super();
		this.username = username;
		this.phoneNumber = phoneNumber;
	}
	
}
