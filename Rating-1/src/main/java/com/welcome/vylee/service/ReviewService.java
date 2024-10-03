package com.welcome.vylee.service;

import com.welcome.vylee.dto.ReviewDTO;

public interface ReviewService {
    ReviewDTO submitReview(ReviewDTO reviewDTO);
    ReviewDTO getReview(Long id);
}
