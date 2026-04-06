package com.finance.controller;

import com.finance.dto.request.FinancialEntryRequest;
import com.finance.dto.response.FinancialEntryResponse;
import com.finance.model.enums.EntryType;
import com.finance.service.FinancialEntryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/financial-entries")
@RequiredArgsConstructor
public class FinancialEntryController {

    private final FinancialEntryService entryService;

    @GetMapping
    public ResponseEntity<List<FinancialEntryResponse>> getAll(
            Principal principal,
            @RequestParam(required = false) EntryType type,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return ResponseEntity.ok(entryService.getEntries(principal.getName(), type, category, from, to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinancialEntryResponse> getById(@PathVariable Long id, Principal principal) {
        return ResponseEntity.ok(entryService.getById(id, principal.getName()));
    }

    @PostMapping
    public ResponseEntity<FinancialEntryResponse> create(@Valid @RequestBody FinancialEntryRequest request,
                                                          Principal principal) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(entryService.create(request, principal.getName()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinancialEntryResponse> update(@PathVariable Long id,
                                                          @Valid @RequestBody FinancialEntryRequest request,
                                                          Principal principal) {
        return ResponseEntity.ok(entryService.update(id, request, principal.getName()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, Principal principal) {
        entryService.delete(id, principal.getName());
        return ResponseEntity.noContent().build();
    }
}
