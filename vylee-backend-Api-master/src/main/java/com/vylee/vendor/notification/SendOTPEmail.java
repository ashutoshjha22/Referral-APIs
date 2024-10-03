package com.vylee.vendor.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendOTPEmail {

	@Autowired
	private JavaMailSender mailSender;

	public String sendOTPEmail(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		message.setFrom("support@vyleesalon.in");

		mailSender.send(message);

		return "OTP send Successfully";
	}

}
