package com.github.fictionaldollop.service;

import com.github.fictionaldollop.controller.dto.ProductDto;
import com.github.fictionaldollop.controller.dto.ProductReviewDto;
import com.github.fictionaldollop.domain.Product;
import com.github.fictionaldollop.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ReviewService reviewService;
    private final ProductRepository productRepository;

    public ProductService(ReviewService reviewService, ProductRepository productRepository) {
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
}
