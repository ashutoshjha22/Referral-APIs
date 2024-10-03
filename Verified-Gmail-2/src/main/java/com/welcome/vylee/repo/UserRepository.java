package com.welcome.vylee.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.welcome.vylee.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByVerificationToken(String token);
}