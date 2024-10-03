package com.welcome.vylee.EmailService;

public interface EmailService {
    void sendVerificationEmail(String email, String token);
}