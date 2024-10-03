package com.welcome.vylee.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.welcome.vylee.dto.ReviewDTO;
import com.welcome.vylee.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewDTO> submitReview(@RequestBody ReviewDTO reviewDTO) {
        ReviewDTO createdReview = reviewService.submitReview(reviewDTO);
        return ResponseEntity.ok(createdReview);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getReview(@PathVariable Long id) {
        ReviewDTO reviewDTO = reviewService.getReview(id);
        return ResponseEntity.ok(reviewDTO);
    }
}
