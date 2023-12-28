package com.github.fictionaldollop.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @Column(name = "is_rating_enabled")
    private Boolean isRatingEnabled;

    @Column(name = "is_commenting_enabled")
    private Boolean isCommentingEnabled;

    @Column(name = "only_buyers_can_review")
    private Boolean onlyBuyersCanReview;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @Column(name = "review_count")
    private Long reviewCount;

    @Column(name = "average_rating")
    private Float averageRating;

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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Boolean isRatingEnabled() {
        return isRatingEnabled;
    }

    public void setRatingEnabled(Boolean ratingEnabled) {
        isRatingEnabled = ratingEnabled;
    }

    public Boolean isCommentingEnabled() {
        return isCommentingEnabled;
    }

    public void setCommentingEnabled(Boolean commentingEnabled) {
        isCommentingEnabled = commentingEnabled;
    }

    public Boolean isOnlyBuyersCanReview() {
        return onlyBuyersCanReview;
    }

    public void setOnlyBuyersCanReview(Boolean onlyBuyersCanReview) {
        this.onlyBuyersCanReview = onlyBuyersCanReview;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
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
}
