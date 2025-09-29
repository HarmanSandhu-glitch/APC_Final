package com.project.pms.performanceservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "kpis")
@Data
public class Kpi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double targetValue;
}