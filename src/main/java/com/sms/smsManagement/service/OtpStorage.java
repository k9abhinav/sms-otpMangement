package com.sms.smsManagement.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class OtpStorage {
	private final Map <String, String> otpMap = new HashMap <>();

    public void storeOtp(String phoneNumber, String otp) {
        otpMap.put(phoneNumber, otp);
    }

    public String getOtp(String phoneNumber) {
        return otpMap.get(phoneNumber);
    }

    public void clearOtp(String phoneNumber) {
        otpMap.remove(phoneNumber);
    }

}
