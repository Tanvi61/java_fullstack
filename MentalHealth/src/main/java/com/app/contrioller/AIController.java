package com.app.contrioller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "http://localhost:4200")
public class AIController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/predict")
    public ResponseEntity<?> predict(@RequestBody Map<String, Object> data) {

        try {
            String url = "http://localhost:5000/predict";
           
            Map response = restTemplate.postForObject(url, data, Map.class);

            return ResponseEntity.ok(response.get("stress"));
        } catch (Exception e) {
            return new ResponseEntity<>("ML API Error: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}