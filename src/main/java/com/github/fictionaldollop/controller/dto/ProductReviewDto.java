package com.github.fictionaldollop.controller.dto;

import com.github.fictionaldollop.domain.Review;

public class ProductReviewDto {

    private Long id;
    private String comment;
    private Float rating;
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

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public static ProductReviewDto map(Review review){
        var productReviewDto = new ProductReviewDto();
        productReviewDto.setId(review.getId());
        productReviewDto.setComment(review.getComment());
        productReviewDto.setRating(review.getRating());
        productReviewDto.setUser(UserDto.map(review.getUser()));
        return productReviewDto;
    }
}
