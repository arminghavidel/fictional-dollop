package com.github.fictionaldollop.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review extends BaseEntity{

    @Column(name = "comment")
    private String comment;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "is_approved")
    private Boolean isApproved;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static ReviewBuilder builder(){
        return new ReviewBuilder();
    }

    public static class ReviewBuilder{
        private String comment;
        private Float rating;
        private Boolean isApproved;
        private Product product;
        private User user;

        public ReviewBuilder comment(String comment){
            this.comment = comment;
            return this;
        }

        public ReviewBuilder rating(Float rating){
            this.rating = rating;
            return this;
        }

        public ReviewBuilder isApproved(Boolean isApproved){
            this.isApproved = isApproved;
            return this;
        }

        public ReviewBuilder product(Product product){
            this.product = product;
            return this;
        }

        public ReviewBuilder user(User user){
            this.user = user;
            return this;
        }

        public Review build(){
            var review = new Review();
            review.setComment(this.comment);
            review.setRating(this.rating);
            review.setApproved(this.isApproved);
            review.setProduct(this.product);
            review.setUser(this.user);
            return review;
        }
    }
}
