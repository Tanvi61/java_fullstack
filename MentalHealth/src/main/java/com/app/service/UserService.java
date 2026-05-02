package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.User;
import com.app.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User register(User user) {
        return repo.save(user);
    }

    public User login(User user) {

        Optional<User> existing = repo.findByUsername(user.getUsername());

        if (existing.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        if (!existing.get().getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return existing.get();
    }
}