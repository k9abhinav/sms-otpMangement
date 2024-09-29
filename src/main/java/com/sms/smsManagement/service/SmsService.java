package com.sms.smsManagement.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sms.smsManagement.TwilioConfig;
import com.sms.smsManagement.dto.OtpRequest;
import com.sms.smsManagement.dto.OtpResponse;
import com.sms.smsManagement.dto.OtpStatus;
import com.sms.smsManagement.dto.OtpValidationRequest;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SmsService {

	@Autowired
	private TwilioConfig twilioConfig;
	Map<String, String> otpMap = new HashMap<>();

	public OtpResponse sendSMS(OtpRequest otpRequest) {
		OtpResponse otpResponse = null;
		try {
			PhoneNumber to = new PhoneNumber(otpRequest.getPhoneNumber());// to
			PhoneNumber from = new PhoneNumber(twilioConfig.getPhoneNumber()); // from
			String otp = generateOTP();
			String otpMessage = "Dear Customer , Your OTP is  " + otp
					+ " for sending sms through Spring boot application. Thank You.";
			Message message = Message.creator(to, from, otpMessage).create();
			otpMap.put(otpRequest.getUsername(), otp);
			otpResponse = new OtpResponse(OtpStatus.DELIVERED, otpMessage);
		} catch (Exception e) {
			e.printStackTrace();
			otpResponse = new OtpResponse(OtpStatus.FAILED, e.getMessage());
		}
		return otpResponse;
	}

	public String validateOtp(OtpValidationRequest otpValidationRequest) {
		Set<String> keys = otpMap.keySet();
		String username = null;
		for (String key : keys)
			username = key;
		if (otpValidationRequest.getUsername().equals(username)) {
			otpMap.remove(username, otpValidationRequest.getOtpNumber());
			return "OTP is valid!";
		} else {
			return "OTP is invalid!";
		}
	}

	private String generateOTP() {
		return new DecimalFormat("000000").format(new Random().nextInt(999999));
	}

}