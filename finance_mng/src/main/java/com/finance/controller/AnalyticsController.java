package com.finance.controller;

import com.finance.dto.response.AnalyticsSummaryResponse;
import com.finance.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/summary")
    public ResponseEntity<AnalyticsSummaryResponse> getSummary(Principal principal) {
        return ResponseEntity.ok(analyticsService.getSummary(principal.getName()));
    }
}
