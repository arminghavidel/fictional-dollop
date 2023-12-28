package com.github.fictionaldollop.controller;

import com.github.fictionaldollop.controller.dto.ReviewDto;
import com.github.fictionaldollop.service.ProductService;
import com.github.fictionaldollop.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;
    private final ProductService productService;

    public ReviewController(ReviewService reviewService, ProductService productService) {
        this.reviewService = reviewService;
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<ReviewDto>> reviews(@RequestParam(required = false) Boolean isApproved, Pageable pageable) {
        return ResponseEntity.ok(reviewService.reviews(isApproved, pageable));
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewDto> review(@PathVariable Long reviewId) {
        return ResponseEntity.ok(reviewService.review(reviewId));
    }

    @PostMapping("/{reviewId}/approve")
    public ResponseEntity<Void> approveReview(@PathVariable Long reviewId){
        var review = reviewService.approveReview(reviewId);
        productService.updateProductRating(review);
        return ResponseEntity.ok().build();
    }
}
