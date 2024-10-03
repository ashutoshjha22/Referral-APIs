package com.welcome.vylee.service;

import com.welcome.vylee.model.Review;

public interface ReviewService {
    Review submitReview(Review review);
    Review getReview(Long id);
}
