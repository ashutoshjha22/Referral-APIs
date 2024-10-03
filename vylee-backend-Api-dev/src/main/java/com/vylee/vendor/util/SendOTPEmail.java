package com.vylee.vendor.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

//	//email send with attachment
//	public void sendmailwithattachment(String to,String msg,String subject,String attachment) throws MessagingException
//	{
//		MimeMessage mimeMessage = mailSender.createMimeMessage();
//		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
//		messageHelper.setFrom("chitrakoothospital108@gmail.com");
//		messageHelper.setTo(to);
//		messageHelper.setText(msg);
//		messageHelper.setSubject(subject);
//		FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
//		messageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
//		mailSender.send(mimeMessage);
//		System.out.println("Email Send Successfully....");
//	}

}
