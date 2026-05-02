package com.finance.dto.request;

import com.finance.model.enums.EntryType;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class FinancialEntryRequest {

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be positive")
    @Digits(integer = 13, fraction = 2, message = "Invalid amount format")
    private BigDecimal amount;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Type is required (INCOME or EXPENSE)")
    private EntryType type;

    private String description;

    @NotNull(message = "Date is required")
    private LocalDate date;
}
