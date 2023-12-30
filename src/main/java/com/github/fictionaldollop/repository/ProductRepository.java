package com.github.fictionaldollop.repository;

import com.github.fictionaldollop.domain.Product;
import com.github.fictionaldollop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
            SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Product p
            JOIN p.buyers b
            WHERE p = :product
            AND b = :user
            """)
    boolean isUserABuyer(Product product, User user);
}
