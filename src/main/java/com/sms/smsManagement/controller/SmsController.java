package com.sms.smsManagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smsManagement.dto.OtpRequest;
import com.sms.smsManagement.dto.OtpResponse;
import com.sms.smsManagement.dto.OtpValidationRequest;
import com.sms.smsManagement.service.SmsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/otp")
@Slf4j
public class SmsController {
	
	private static final Logger log = LoggerFactory.getLogger(SmsController.class);
	@Autowired
	private SmsService smsService;
	
	@GetMapping
	("/process")
	public String processSMS() {
		return "SMS sent";
	}

	@PostMapping("/send-otp")
	public OtpResponse sendOtp(@RequestBody OtpRequest otpRequest) {
		log.info("inside sendOtp :: "+otpRequest.getUsername());
		return smsService.sendSMS(otpRequest);
	}
	@PostMapping("/validate-otp")
    public String validateOtp(@RequestBody OtpValidationRequest otpValidationRequest) {
		log.info("inside validateOtp :: "+otpValidationRequest.getUsername()+" "+otpValidationRequest.getOtpNumber());
		return smsService.validateOtp(otpValidationRequest);
    }

}