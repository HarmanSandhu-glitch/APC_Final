package com.project.pms.expenseservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
@Data
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employeeId;
    private String category;
    private BigDecimal amount;
    private LocalDate expenseDate;
    private String status; // e.g., "Submitted", "Approved", "Rejected"
}