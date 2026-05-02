package com.app.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Mood;

public interface MoodRepository extends JpaRepository<Mood, Long> {
    List<Mood> findByUserId(Long userId);
}