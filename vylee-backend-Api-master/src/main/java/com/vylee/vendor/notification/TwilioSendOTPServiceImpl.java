package com.vylee.vendor.notification;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioSendOTPServiceImpl implements TwilioSendOTPService {

	// Twilio account SID and Auth Token should be stored securely, not hardcoded
	String accountSid = "Enter SID";
	String authToken = "Enter AUth Token";

	@Override
	public String sendOTP(String toMobile) {
		// TODO Auto-generated method stub

		int otp = new Random().nextInt(9999 - 1000 + 1) + 1000; // Ensure OTP is 5 digits

		String textMessage = "LOGIN OTP" + " " + "Use OTP" + " " + otp + " "
				+ "to log into your VYLEE account. Do not share the OTP or your number with anyone including Vylee personnel.";

		try {
			// Initialize Twilio client

			Twilio.init(accountSid, authToken);
			// Create and send the message
			Message message = Message.creator(new PhoneNumber(toMobile), // To phone number
					new PhoneNumber("Enter Phone Number"), // From phone number (must be a Twilio number)
					textMessage // Message body
			).create();

			return message.getSid();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
