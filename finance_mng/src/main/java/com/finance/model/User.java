package com.finance.model;

import com.finance.model.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(unique = true, nullable = false)
	    private String email;

	    @Column(nullable = false)
	    private String password;

	    @Column(nullable = false)
	    private String name;

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    @Builder.Default
	    private Role role = Role.VIEWER;

	    @Column(name = "created_at")
	    @Builder.Default
	    private LocalDateTime createdAt = LocalDateTime.now();

	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	    private List<FinancialEntry> entries;


}
