package com.github.fictionaldollop.controller.dto;

import com.github.fictionaldollop.domain.Product;

import java.util.List;

public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private ProviderDto provider;
    private Boolean isRatingEnabled;
    private Boolean isCommentingEnabled;
    private Boolean onlyBuyersCanReview;
    private List<ProductReviewDto> reviews;
    private Long reviewCount;
    private Float averageRating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProviderDto getProvider() {
        return provider;
    }

    public void setProvider(ProviderDto provider) {
        this.provider = provider;
    }

    public Boolean getRatingEnabled() {
        return isRatingEnabled;
    }

    public void setRatingEnabled(Boolean ratingEnabled) {
        isRatingEnabled = ratingEnabled;
    }

    public Boolean getCommentingEnabled() {
        return isCommentingEnabled;
    }

    public void setCommentingEnabled(Boolean commentingEnabled) {
        isCommentingEnabled = commentingEnabled;
    }

    public Boolean getOnlyBuyersCanReview() {
        return onlyBuyersCanReview;
    }

    public void setOnlyBuyersCanReview(Boolean onlyBuyersCanReview) {
        this.onlyBuyersCanReview = onlyBuyersCanReview;
    }

    public List<ProductReviewDto> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProductReviewDto> reviews) {
        this.reviews = reviews;
    }

    public Long getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Long reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Float averageRating) {
        this.averageRating = averageRating;
    }

    public static ProductDto map(Product product){
        var productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setProvider(ProviderDto.map(product.getProvider()));
        productDto.setRatingEnabled(product.getRatingEnabled());
        productDto.setCommentingEnabled(product.getCommentingEnabled());
        productDto.setOnlyBuyersCanReview(product.getOnlyBuyersCanReview());
        productDto.setReviewCount(product.getReviewCount());
        productDto.setAverageRating(product.getAverageRating());
        return productDto;
    }
}
