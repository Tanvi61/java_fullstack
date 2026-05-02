package com.finance.model;

import com.finance.model.enums.EntryType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "financial_entries")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinancialEntry {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, precision = 15, scale = 2)
	    private BigDecimal amount;

	    @Column(nullable = false)
	    private String category;

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private EntryType type;

	    private String description;

	    @Column(nullable = false)
	    private LocalDate date;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;

	    @Column(name = "created_at")
	    @Builder.Default
	    private LocalDateTime createdAt = LocalDateTime.now();

	    @Column(name = "updated_at")
	    @Builder.Default
	    private LocalDateTime updatedAt = LocalDateTime.now();

	    @PreUpdate
	    protected void onUpdate() {
	        this.updatedAt = LocalDateTime.now();
	    }

}
