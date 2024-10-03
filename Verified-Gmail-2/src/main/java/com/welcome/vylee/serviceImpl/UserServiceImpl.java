package com.welcome.vylee.serviceImpl;
import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welcome.vylee.EmailService.EmailService;
import com.welcome.vylee.model.User;
import com.welcome.vylee.repo.UserRepository;
import com.welcome.vylee.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash password
        String token = generateVerificationToken(); // Generate token
        user.setVerificationToken(token);
        user.setEnabled(false);
        userRepository.save(user); // Save user

        emailService.sendVerificationEmail(user.getEmail(), token); // Send email
    }

    @Override
    public boolean verifyEmail(String token) {
        return userRepository.findByVerificationToken(token)
                .map(user -> {
                    user.setEnabled(true);
                    user.setVerificationToken(null);
                    userRepository.save(user);
                    return true;
                })
                .orElse(false);
    }

    private String generateVerificationToken() {
        byte[] randomBytes = new byte[24];
        new SecureRandom().nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }
}