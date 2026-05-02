package com.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.PhysiologicalData;
import com.app.repository.PhysiologicalRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PhysiologicalService {

    @Autowired
    private PhysiologicalRepository repo;

    public PhysiologicalData save(PhysiologicalData data) {
        data.setTimestamp(LocalDateTime.now());
        return repo.save(data);
    }

    public List<PhysiologicalData> get(Long userId) {
        return repo.findByUserId(userId);
    }
}