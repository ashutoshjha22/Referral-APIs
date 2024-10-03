package com.login.gmail.service;

import com.login.gmail.model.User;

public interface UserService {
    User findOrCreateUser(String email, String name, String picture);
}
