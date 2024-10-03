package com.welcome.vylee.ctrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.welcome.vylee.model.User;
import com.welcome.vylee.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return "Registration successful, please check your email to verify your account.";
    }

    @GetMapping("/verify/{token}")
    public String verifyUser(@RequestParam("token") String token) {
        userService.verifyEmail(token);
        return "Email verified successfully!";
    }
}
