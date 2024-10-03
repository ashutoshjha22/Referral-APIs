package com.welcome.vylee.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welcome.vylee.model.Review;
import com.welcome.vylee.repo.ReviewRepository;
import com.welcome.vylee.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review submitReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review getReview(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));
    }
}
