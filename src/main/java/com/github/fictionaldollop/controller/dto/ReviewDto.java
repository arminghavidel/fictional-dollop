package com.github.fictionaldollop.controller.dto;

import com.github.fictionaldollop.domain.Review;

public class ReviewDto {
    private Long id;
    private String comment;
    private Float rating;
    private boolean isApproved;
    private ReviewProductDto product;
    private UserDto user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public ReviewProductDto getProduct() {
        return product;
    }

    public void setProduct(ReviewProductDto product) {
        this.product = product;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public static ReviewDto map(Review review){
        var reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setComment(review.getComment());
        reviewDto.setRating(review.getRating());
        reviewDto.setApproved(review.getApproved());
        reviewDto.setProduct(ReviewProductDto.map(review.getProduct()));
        reviewDto.setUser(UserDto.map(review.getUser()));
        return reviewDto;
    }
}
