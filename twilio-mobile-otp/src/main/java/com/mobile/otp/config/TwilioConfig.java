package com.mobile.otp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
public class TwilioConfig {
	
    private String accountSid;
    
    private String authToken;
    
    private String trialNumber;
    
	public String getAccountSid() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getAuthToken() {
		// TODO Auto-generated method stub
		return null;
	}

}
