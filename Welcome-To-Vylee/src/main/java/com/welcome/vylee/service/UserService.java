package com.welcome.vylee.service;

import java.util.List;

import com.welcome.vylee.model.User;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User userDetails);
    void deleteUser(Long id);
}
