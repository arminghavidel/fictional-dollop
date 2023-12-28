package com.github.fictionaldollop.service;

import com.github.fictionaldollop.domain.User;
import com.github.fictionaldollop.repository.UserRepository;
import com.github.fictionaldollop.service.exception.FictionalNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new FictionalNotFoundException("User not found!"));
    }
}
