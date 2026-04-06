package com.finance.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class AnalyticsSummaryResponse {
    private BigDecimal totalIncome;
    private BigDecimal totalExpense;
    private BigDecimal netBalance;
    private long totalEntries;
    private List<CategoryBreakdown> categoryBreakdown;

    @Data
    @Builder
    public static class CategoryBreakdown {
        private String category;
        private BigDecimal totalAmount;
    }
}
