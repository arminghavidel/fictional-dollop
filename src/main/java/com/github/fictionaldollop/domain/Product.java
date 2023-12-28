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
    private boolean isRatingEnabled;

    @Column(name = "is_commenting_enabled")
    private boolean isCommentingEnabled;

    @Column(name = "only_buyers_can_review")
    private boolean onlyBuyersCanReview;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

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

    public boolean isRatingEnabled() {
        return isRatingEnabled;
    }

    public void setRatingEnabled(boolean ratingEnabled) {
        isRatingEnabled = ratingEnabled;
    }

    public boolean isCommentingEnabled() {
        return isCommentingEnabled;
    }

    public void setCommentingEnabled(boolean commentingEnabled) {
        isCommentingEnabled = commentingEnabled;
    }

    public boolean isOnlyBuyersCanReview() {
        return onlyBuyersCanReview;
    }

    public void setOnlyBuyersCanReview(boolean onlyBuyersCanReview) {
        this.onlyBuyersCanReview = onlyBuyersCanReview;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
