package com.project.pms.performanceservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "performance_reviews")
@Data
public class PerformanceReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employeeId;
    private Long reviewerId;
    private LocalDate reviewDate;
    @Lob
    private String comments;
    private Integer rating;
}