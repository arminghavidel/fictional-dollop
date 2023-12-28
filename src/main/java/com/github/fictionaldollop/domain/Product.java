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

    @Column()

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Provider getProvider() {
        return provider;
    }

    public boolean isRatingEnabled() {
        return isRatingEnabled;
    }

    public boolean isCommentingEnabled() {
        return isCommentingEnabled;
    }

    public boolean isOnlyBuyersCanReview() {
        return onlyBuyersCanReview;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
