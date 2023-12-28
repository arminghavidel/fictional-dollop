package com.github.fictionaldollop.repository;

import com.github.fictionaldollop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
