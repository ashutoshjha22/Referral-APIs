package com.welcome.vylee.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welcome.vylee.dto.ReviewDTO;
import com.welcome.vylee.model.Review;
import com.welcome.vylee.repo.ReviewRepository;
import com.welcome.vylee.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ReviewDTO submitReview(ReviewDTO reviewDTO) {
        // Convert DTO to entity
        Review review = modelMapper.map(reviewDTO, Review.class);
        
        // Save to DB
        Review savedReview = reviewRepository.save(review);
        
        // Convert back to DTO
        return modelMapper.map(savedReview, ReviewDTO.class);
    }

    @Override
    public ReviewDTO getReview(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));
        
        // Convert to DTO and return
        return modelMapper.map(review, ReviewDTO.class);
    }
}
