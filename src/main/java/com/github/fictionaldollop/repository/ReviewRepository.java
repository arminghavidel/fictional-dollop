package com.github.fictionaldollop.repository;

import com.github.fictionaldollop.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("""
            SELECT r FROM Review r
            WHERE r.product.id = :productId
            AND r.isApproved = true
            ORDER BY r.createdAt DESC
            """)
    List<Review> findApprovedReviewsByProductOrderedByCreationDateDesc(Long productId);

    @Query("""
            SELECT r FROM Review r
            WHERE (:isApproved IS NULL OR r.isApproved = :isApproved)
            ORDER BY r.createdAt DESC
            """)
    Page<Review> findAllByIsApprovedOrNullOrderedByCreationDateDesc(Boolean isApproved, Pageable pageable);
}
