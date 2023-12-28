package com.github.fictionaldollop.controller.dto;

import jakarta.validation.constraints.Positive;

public class AddReviewRequest {

    private String comment;

    @Positive
    private Float rating;

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
}
