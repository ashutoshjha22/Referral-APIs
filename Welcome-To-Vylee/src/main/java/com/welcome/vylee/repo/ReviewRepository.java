package com.welcome.vylee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.welcome.vylee.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
