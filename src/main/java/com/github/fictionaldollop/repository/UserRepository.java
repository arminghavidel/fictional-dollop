package com.github.fictionaldollop.repository;

import com.github.fictionaldollop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
