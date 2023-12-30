package com.github.fictionaldollop.service;

import com.github.fictionaldollop.controller.dto.AddReviewRequest;
import com.github.fictionaldollop.controller.dto.ProductDto;
import com.github.fictionaldollop.controller.dto.ProductReviewDto;
import com.github.fictionaldollop.domain.Product;
import com.github.fictionaldollop.domain.Review;
import com.github.fictionaldollop.domain.User;
import com.github.fictionaldollop.repository.ProductRepository;
import com.github.fictionaldollop.service.exception.FictionalBadRequestException;
import com.github.fictionaldollop.service.exception.FictionalNotFoundException;
import com.github.fictionaldollop.service.exception.FictionalUnAuthorizedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final UserService userService;
    private final ReviewService reviewService;
    private final ProductRepository productRepository;

    public ProductService(UserService userService, ReviewService reviewService, ProductRepository productRepository) {
        this.userService = userService;
        this.reviewService = reviewService;
        this.productRepository = productRepository;
    }

    public Page<ProductDto> products(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(this::mapToProductDto);
    }

    private ProductDto mapToProductDto(Product p) {
        var productDto = ProductDto.map(p);
        var lastThreeReviews = reviewService.findLastThreeReviews(p.getId())
                .stream()
                .map(ProductReviewDto::map)
                .toList();
        productDto.setReviews(lastThreeReviews);
        return productDto;
    }

    public void addReview(Long userId, Long productId, AddReviewRequest request) {
        var user = userService.findUserById(userId);
        var product = findProductById(productId);
        validateRequest(product, user, request);
        reviewService.createReview(user, product, request);
    }

    private Product findProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new FictionalNotFoundException("Product not found!"));
    }

    private void validateRequest(Product product, User user, AddReviewRequest request) {
        if (!product.isRatingEnabled() && request.getRating() != null)
            throw new FictionalBadRequestException("Rating is not allowed for this product!");

        if (!product.isCommentingEnabled() && request.getComment() != null)
            throw new FictionalBadRequestException("Commenting is not allowed for this product!");

        if (product.isOnlyBuyersCanReview() && !productRepository.isUserABuyer(product, user))
            throw new FictionalUnAuthorizedException("Review not allowed for this user!");
    }

    public void updateProductRating(Review review) {
        var product = review.getProduct();

        float lastAverageRating = product.getAverageRating() != null ? product.getAverageRating() : 0f;
        long lastReviewCount = product.getReviewCount() != null ? product.getReviewCount() : 0;

        float newRatingSum = (lastAverageRating * lastReviewCount) + review.getRating();
        long newReviewCount = lastReviewCount + 1;

        float newAverageRating = newRatingSum / newReviewCount;

        product.setAverageRating(newAverageRating);
        product.setReviewCount(newReviewCount);
        productRepository.save(product);
    }
}
