package com.github.fictionaldollop.controller;

import com.github.fictionaldollop.controller.dto.AddReviewRequest;
import com.github.fictionaldollop.controller.dto.ProductDto;
import com.github.fictionaldollop.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<ProductDto>> products(Pageable pageable) {
        return ResponseEntity.ok(productService.products(pageable));
    }

    /**
     * TODO: Replace the 'user_id' retrieval from header with user information
     *       obtained from Spring Security's UserDetails after implementing authentication.
     */
    @PostMapping("/{productId}/review")
    public ResponseEntity<Void> addReview(
            @RequestHeader("user_id") Long userId,
            @PathVariable Long productId,
            @RequestBody AddReviewRequest request
    ) {
        productService.addReview(userId, productId, request);
        return ResponseEntity.ok().build();
    }
}
