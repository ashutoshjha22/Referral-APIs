package com.welcome.vylee.service;
import com.welcome.vylee.model.User;

public interface UserService {
    void registerUser(User user);
    boolean verifyEmail(String token);
}