package com.welcome.vylee.ctrl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.welcome.vylee.model.User;
import com.welcome.vylee.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		userService.registerUser(user);
		return ResponseEntity.ok("User registered successfully. Check your email for verification link.");
	}

	@GetMapping("/verify-email")
	public ResponseEntity<String> verifyEmail(@RequestParam String token) {
		boolean isVerified = userService.verifyEmail(token);
		if (isVerified) {
			return ResponseEntity.ok("Email verified successfully.");
		}
		return ResponseEntity.badRequest().body("Invalid verification token.");
	}

}
