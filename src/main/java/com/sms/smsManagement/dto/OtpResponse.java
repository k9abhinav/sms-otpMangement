package com.sms.smsManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OtpResponse {
	private OtpStatus status;
    private String message;
	public OtpResponse(OtpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public OtpResponse() {
		super();
	}
	public OtpStatus getStatus() {
		return status;
	}
	public void setStatus(OtpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    
}
