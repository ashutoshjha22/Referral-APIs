package com.welcome.vylee.serviceImpl;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.welcome.vylee.model.User;
import com.welcome.vylee.repo.UserRepository;
import com.welcome.vylee.service.UserService;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public User registerUser(User user) {
		user.setVerificationToken(UUID.randomUUID().toString());
		userRepository.save(user);
		sendVerificationEmail(user);
		return user;
	}

	@Transactional
	@Override
	public void verifyEmail(String token) {
		Optional<User> userOptional = userRepository.findByVerificationToken(token);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			user.setVerified(true);
			user.setVerificationToken(null); // Clear token after verification
			userRepository.save(user);
		} else {
			throw new IllegalArgumentException("Invalid token");
		}
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	private void sendVerificationEmail(User user) {
		String subject = "Email Verification";
		String verificationUrl = "http://localhost:9090/api/verify?token=" + user.getVerificationToken();

		// For sending image in email
		String htmlMessage = "<html><body>" + "<h1>Verify your email</h1>"
				+ "<p>Click the link to verify your email: <a href=\"" + verificationUrl + "\">Verify Now</a></p>"
				+ "</body></html>";

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(user.getEmail());
			helper.setSubject(subject);
			helper.setText(htmlMessage, true); // Send HTML message

			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
