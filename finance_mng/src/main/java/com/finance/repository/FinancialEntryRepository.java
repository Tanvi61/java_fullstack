package com.finance.repository;

import com.finance.model.FinancialEntry;
import com.finance.model.enums.EntryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface FinancialEntryRepository extends JpaRepository<FinancialEntry, Long> {

    List<FinancialEntry> findByUserId(Long userId);

    List<FinancialEntry> findByUserIdAndType(Long userId, EntryType type);

    @Query("SELECT SUM(e.amount) FROM FinancialEntry e WHERE e.type = :type")
    BigDecimal sumByType(@Param("type") EntryType type);

    @Query("SELECT SUM(e.amount) FROM FinancialEntry e WHERE e.user.id = :userId AND e.type = :type")
    BigDecimal sumByUserIdAndType(@Param("userId") Long userId, @Param("type") EntryType type);

    @Query("SELECT e.category, SUM(e.amount) FROM FinancialEntry e GROUP BY e.category ORDER BY SUM(e.amount) DESC")
    List<Object[]> sumByCategory();

    @Query("SELECT e.category, SUM(e.amount) FROM FinancialEntry e WHERE e.user.id = :userId GROUP BY e.category ORDER BY SUM(e.amount) DESC")
    List<Object[]> sumByCategoryForUser(@Param("userId") Long userId);

    @Query("SELECT e FROM FinancialEntry e WHERE (:type IS NULL OR e.type = :type) AND (:category IS NULL OR LOWER(e.category) LIKE LOWER(CONCAT('%',:category,'%'))) AND (:from IS NULL OR e.date >= :from) AND (:to IS NULL OR e.date <= :to) ORDER BY e.date DESC")
    List<FinancialEntry> filterAll(@Param("type") EntryType type,
                                   @Param("category") String category,
                                   @Param("from") LocalDate from,
                                   @Param("to") LocalDate to);

    @Query("SELECT e FROM FinancialEntry e WHERE e.user.id = :userId AND (:type IS NULL OR e.type = :type) AND (:category IS NULL OR LOWER(e.category) LIKE LOWER(CONCAT('%',:category,'%'))) AND (:from IS NULL OR e.date >= :from) AND (:to IS NULL OR e.date <= :to) ORDER BY e.date DESC")
    List<FinancialEntry> filterByUser(@Param("userId") Long userId,
                                       @Param("type") EntryType type,
                                       @Param("category") String category,
                                       @Param("from") LocalDate from,
                                       @Param("to") LocalDate to);
}
