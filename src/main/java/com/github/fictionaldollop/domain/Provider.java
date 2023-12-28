package com.github.fictionaldollop.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "provider")
public class Provider extends BaseEntity{

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "provider")
    private List<Product> products;

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }
}
