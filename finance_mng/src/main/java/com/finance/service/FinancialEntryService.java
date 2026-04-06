package com.finance.service;

import com.finance.dto.request.FinancialEntryRequest;
import com.finance.dto.response.FinancialEntryResponse;
import com.finance.model.FinancialEntry;
import com.finance.model.User;
import com.finance.model.enums.EntryType;
import com.finance.model.enums.Role;
import com.finance.repository.FinancialEntryRepository;
import com.finance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FinancialEntryService {

    private final FinancialEntryRepository entryRepository;
    private final UserRepository userRepository;

    public List<FinancialEntryResponse> getEntries(String email, EntryType type,
                                                    String category, LocalDate from, LocalDate to) {
        User user = getUser(email);

        List<FinancialEntry> entries;
        if (user.getRole() == Role.ADMIN || user.getRole() == Role.ANALYST) {
            entries = entryRepository.filterAll(type, category, from, to);
        } else {
            entries = entryRepository.filterByUser(user.getId(), type, category, from, to);
        }

        return entries.stream().map(FinancialEntryResponse::from).collect(Collectors.toList());
    }

    public FinancialEntryResponse getById(Long id, String email) {
        User user = getUser(email);
        FinancialEntry entry = entryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Entry not found with id: " + id));

        if (user.getRole() == Role.VIEWER && !entry.getUser().getId().equals(user.getId())) {
            throw new AccessDeniedException("You do not have access to this entry");
        }

        return FinancialEntryResponse.from(entry);
    }

    @Transactional
    public FinancialEntryResponse create(FinancialEntryRequest request, String email) {
        User user = getUser(email);

        FinancialEntry entry = FinancialEntry.builder()
                .amount(request.getAmount())
                .category(request.getCategory())
                .type(request.getType())
                .description(request.getDescription())
                .date(request.getDate())
                .user(user)
                .build();

        return FinancialEntryResponse.from(entryRepository.save(entry));
    }

    @Transactional
    public FinancialEntryResponse update(Long id, FinancialEntryRequest request, String email) {
        User user = getUser(email);
        FinancialEntry entry = entryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Entry not found with id: " + id));

        if (user.getRole() == Role.VIEWER) {
            throw new AccessDeniedException("Viewers cannot update entries");
        }
        if (user.getRole() == Role.ANALYST && !entry.getUser().getId().equals(user.getId())) {
            throw new AccessDeniedException("Analysts can only update their own entries");
        }

        entry.setAmount(request.getAmount());
        entry.setCategory(request.getCategory());
        entry.setType(request.getType());
        entry.setDescription(request.getDescription());
        entry.setDate(request.getDate());

        return FinancialEntryResponse.from(entryRepository.save(entry));
    }

    @Transactional
    public void delete(Long id, String email) {
        User user = getUser(email);
        FinancialEntry entry = entryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Entry not found with id: " + id));

        if (user.getRole() != Role.ADMIN) {
            throw new AccessDeniedException("Only ADMINs can delete entries");
        }

        entryRepository.delete(entry);
    }

    private User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + email));
    }
}
