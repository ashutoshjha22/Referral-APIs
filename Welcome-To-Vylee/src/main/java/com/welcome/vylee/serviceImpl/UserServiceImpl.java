package com.welcome.vylee.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welcome.vylee.exception.ResourceNotFoundException;
import com.welcome.vylee.model.User;
import com.welcome.vylee.repo.UserRepository;
import com.welcome.vylee.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public User updateUser(Long id, User userDetails) {
    	User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

    	user.setName(userDetails.getName());
    	user.setLocation(userDetails.getLocation());
    	user.setDateOfBirth(userDetails.getDateOfBirth());
    	user.setType(userDetails.getType());
    	user.setReferralCode(userDetails.getReferralCode());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
    	User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    	userRepository.delete(user);
    }
}
