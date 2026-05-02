package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Mood;
import com.app.repository.MoodRepository;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class MoodService {

    @Autowired
    private MoodRepository repo;

    public Mood save(Mood mood) {
        mood.setTimestamp(LocalDateTime.now());
        return repo.save(mood);
    }

    public List<Mood> getByUser(Long userId) {
        return repo.findByUserId(userId);
    }
}