package com.welcome.vylee.service;
import java.util.Optional;

import com.welcome.vylee.model.User;

public interface UserService {
    User registerUser(User user);
    void verifyEmail(String token);
    Optional<User> findByEmail(String email);
}
