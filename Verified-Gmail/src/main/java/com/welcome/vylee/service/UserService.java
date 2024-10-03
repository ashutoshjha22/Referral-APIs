package com.welcome.vylee.service;

import com.welcome.vylee.model.User;

public interface UserService {
    User registerUser(User user);
    void sendVerificationEmail(User user);
    boolean verifyEmail(String token);
	}
