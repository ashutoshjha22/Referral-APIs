package com.vylee.vendor.twilio;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioSendOTPServiceImpl implements TwilioSendOTPService {

	// Twilio account SID and Auth Token should be stored securely, not hardcoded
	

	@Override
	public String sendOTP(String toMobile) {
		// TODO Auto-generated method stub

		int otp = new Random().nextInt(9999 - 1000 + 1) + 1000; // Ensure OTP is 5 digits

		try {
			// Initialize Twilio client
			
			
			// Create and send the message
			Message message = Message.creator(
				new PhoneNumber(toMobile), // To phone number
				new PhoneNumber(""), // From phone number (must be a Twilio number)
				"Your OTP is: " + otp // Message body
			).create();

			return message.getSid();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
