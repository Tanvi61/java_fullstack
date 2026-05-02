package com.finance;

import com.finance.model.FinancialEntry;
import com.finance.model.User;
import com.finance.model.enums.EntryType;
import com.finance.model.enums.Role;
import com.finance.repository.FinancialEntryRepository;
import com.finance.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class FinanceApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(FinanceApplication.class, args);
	}
	@Bean
    CommandLineRunner seedData(UserRepository userRepository,
                               FinancialEntryRepository entryRepository,
                               PasswordEncoder passwordEncoder) {
        return args -> {
            User admin = userRepository.save(User.builder()
                    .email("admin@finance.com")
                    .password(passwordEncoder.encode("admin123"))
                    .name("Admin User")
                    .role(Role.ADMIN)
                    .build());

            User analyst = userRepository.save(User.builder()
                    .email("analyst@finance.com")
                    .password(passwordEncoder.encode("analyst123"))
                    .name("Analyst User")
                    .role(Role.ANALYST)
                    .build());

            User viewer = userRepository.save(User.builder()
                    .email("viewer@finance.com")
                    .password(passwordEncoder.encode("viewer123"))
                    .name("Viewer User")
                    .role(Role.VIEWER)
                    .build());

            entryRepository.save(FinancialEntry.builder()
                    .amount(new BigDecimal("50000.00"))
                    .category("Salary")
                    .type(EntryType.INCOME)
                    .description("Monthly salary - April")
                    .date(LocalDate.of(2024, 4, 1))
                    .user(admin)
                    .build());

            entryRepository.save(FinancialEntry.builder()
                    .amount(new BigDecimal("1200.00"))
                    .category("Rent")
                    .type(EntryType.EXPENSE)
                    .description("Office rent - April")
                    .date(LocalDate.of(2024, 4, 5))
                    .user(admin)
                    .build());

            entryRepository.save(FinancialEntry.builder()
                    .amount(new BigDecimal("30000.00"))
                    .category("Consulting")
                    .type(EntryType.INCOME)
                    .description("Client consulting fee")
                    .date(LocalDate.of(2024, 4, 10))
                    .user(analyst)
                    .build());

            entryRepository.save(FinancialEntry.builder()
                    .amount(new BigDecimal("500.00"))
                    .category("Travel")
                    .type(EntryType.EXPENSE)
                    .description("Business travel expenses")
                    .date(LocalDate.of(2024, 4, 12))
                    .user(analyst)
                    .build());

            entryRepository.save(FinancialEntry.builder()
                    .amount(new BigDecimal("8000.00"))
                    .category("Investment")
                    .type(EntryType.INCOME)
                    .description("Dividend income")
                    .date(LocalDate.of(2024, 4, 15))
                    .user(viewer)
                    .build());

            System.out.println("\n========================================");
            System.out.println("  Finance Backend Started Successfully");
            System.out.println("========================================");
            System.out.println("  Seeded users:");
            System.out.println("    admin@finance.com   / admin123   [ADMIN]");
            System.out.println("    analyst@finance.com / analyst123 [ANALYST]");
            System.out.println("    viewer@finance.com  / viewer123  [VIEWER]");
            System.out.println("  H2 Console: http://localhost:8080/h2-console");
            System.out.println("  API Base:   http://localhost:8080/api");
            System.out.println("========================================\n");
        };
    }

}
