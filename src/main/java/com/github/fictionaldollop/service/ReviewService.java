package com.github.fictionaldollop.service;

import com.github.fictionaldollop.domain.Review;
import com.github.fictionaldollop.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findLastThreeReviews(Long productId){
        return reviewRepository.findApprovedReviewsByProductOrderedByCreationDateDesc(productId)
                .stream()
                .limit(3)
                .toList();
    }
}
