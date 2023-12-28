package com.github.fictionaldollop.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review extends BaseEntity{

    @Column(name = "comment")
    private String comment;

    @Column(name = "float")
    private float rating;

    @Column(name = "is_approved")
    private boolean isApproved;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getComment() {
        return comment;
    }

    public float getRating() {
        return rating;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public Product getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }
}
