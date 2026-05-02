package com.app.contrioller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.PhysiologicalData;
import com.app.service.PhysiologicalService;

import java.util.List;

@RestController
@RequestMapping("/api/health")
@CrossOrigin(origins = "http://localhost:4200")
public class PhysiologicalController {

    @Autowired
    private PhysiologicalService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PhysiologicalData data) {
        try {
            return ResponseEntity.ok(service.save(data));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> get(@PathVariable Long userId) {
        try {
            List<PhysiologicalData> list = service.get(userId);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}