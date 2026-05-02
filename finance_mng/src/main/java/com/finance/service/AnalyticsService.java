package com.finance.service;

import com.finance.dto.response.AnalyticsSummaryResponse;
import com.finance.model.User;
import com.finance.model.enums.EntryType;
import com.finance.model.enums.Role;
import com.finance.repository.FinancialEntryRepository;
import com.finance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final FinancialEntryRepository entryRepository;
    private final UserRepository userRepository;

    public AnalyticsSummaryResponse getSummary(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        BigDecimal totalIncome;
        BigDecimal totalExpense;
        long totalEntries;
        List<Object[]> categoryRaw;

        if (user.getRole() == Role.ADMIN || user.getRole() == Role.ANALYST) {
            totalIncome = orZero(entryRepository.sumByType(EntryType.INCOME));
            totalExpense = orZero(entryRepository.sumByType(EntryType.EXPENSE));
            totalEntries = entryRepository.count();
            categoryRaw = entryRepository.sumByCategory();
        } else {
            totalIncome = orZero(entryRepository.sumByUserIdAndType(user.getId(), EntryType.INCOME));
            totalExpense = orZero(entryRepository.sumByUserIdAndType(user.getId(), EntryType.EXPENSE));
            totalEntries = entryRepository.findByUserId(user.getId()).size();
            categoryRaw = entryRepository.sumByCategoryForUser(user.getId());
        }

        BigDecimal netBalance = totalIncome.subtract(totalExpense);

        List<AnalyticsSummaryResponse.CategoryBreakdown> categoryBreakdown = categoryRaw.stream()
        		.map(row -> AnalyticsSummaryResponse.CategoryBreakdown.builder()
                        .category((String) row[0])
                        .totalAmount((BigDecimal) row[1])
                        .build())
                .collect(Collectors.toList());

        return AnalyticsSummaryResponse.builder()
                .totalIncome(totalIncome)
                .totalExpense(totalExpense)
                .netBalance(netBalance)
                .totalEntries(totalEntries)
                .categoryBreakdown(categoryBreakdown)
                .build();
    }

    private BigDecimal orZero(BigDecimal value) {
        return value != null ? value : BigDecimal.ZERO;
    }
}
