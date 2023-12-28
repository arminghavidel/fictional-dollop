package com.github.fictionaldollop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseEntity{

    @Column(name = "username")
    private String username;

    public String getUsername() {
        return username;
    }
}
