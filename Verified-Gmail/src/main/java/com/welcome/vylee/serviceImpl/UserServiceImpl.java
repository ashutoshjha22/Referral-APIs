package com.welcome.vylee.serviceImpl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.welcome.vylee.model.User;
import com.welcome.vylee.repo.UserRepository;
import com.welcome.vylee.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

	/*
	 * @Value("${app.frontend.verification.url}") private String frontendUrl;
	 */
    @Override
    public User registerUser(User user) {
        User user1 = new User();
        user1.setName(user1.getName());
        user1.setEmail(user1.getEmail());
        user1.setPassword(user1.getPassword());
        
        // Generate verification token
        String token = UUID.randomUUID().toString();
        user1.setVerificationToken(token);

        // Save the user
        user1 = userRepository.save(user1);

        // Send verification email
        sendVerificationEmail(user1);

        return user1;
    }

    @Override
    public void sendVerificationEmail(User user) {
        String verificationUrl = "Hello" + "/verify-email?token=" + user.getVerificationToken();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Email Verification");
        message.setText("Click the following link to verify your email: " + verificationUrl);
        mailSender.send(message);
    }

    @Override
    public boolean verifyEmail(String token) {
        Optional<User> optionalUser = userRepository.findByVerificationToken(token);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEmailVerified(true);
            userRepository.save(user);
            return true;
        }
        return false;
    }

			
}
