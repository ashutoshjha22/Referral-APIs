package com.login.gmail.serviceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.login.gmail.model.User;
import com.login.gmail.repo.UserRepository;
import com.login.gmail.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findOrCreateUser(String email, String name, String picture) {
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            return existingUser.get();
        }

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setName(name);
        newUser.setPicture(picture);

        return userRepository.save(newUser);
    }
}
