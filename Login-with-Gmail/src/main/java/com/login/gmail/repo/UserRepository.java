package com.login.gmail.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.gmail.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
