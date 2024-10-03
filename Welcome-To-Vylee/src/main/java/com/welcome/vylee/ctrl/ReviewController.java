package com.welcome.vylee.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.welcome.vylee.model.Review;
import com.welcome.vylee.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public Review submitReview(@RequestBody Review review) {
        return reviewService.submitReview(review);
    }

    @GetMapping("/{id}")
    public Review getReview(@PathVariable Long id) {
        return reviewService.getReview(id);
    }
}
