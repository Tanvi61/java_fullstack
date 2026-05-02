package com.app.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.PhysiologicalData;

public interface PhysiologicalRepository extends JpaRepository<PhysiologicalData, Long> {
    List<PhysiologicalData> findByUserId(Long userId);
}
