package com.welcome.vylee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.welcome.vylee.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
