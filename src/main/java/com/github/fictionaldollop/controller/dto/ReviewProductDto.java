package com.github.fictionaldollop.controller.dto;

import com.github.fictionaldollop.domain.Product;

public class ReviewProductDto {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ReviewProductDto map(Product product){
        var reviewProductDto = new ReviewProductDto();
        reviewProductDto.setId(product.getId());
        reviewProductDto.setName(product.getName());
        return reviewProductDto;
    }
}
