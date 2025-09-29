package com.project.pms.trainingservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee_skills")
@Data
public class EmployeeSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employeeId;
    private String skillName;
    private String proficiencyLevel; // e.g., "Beginner", "Intermediate", "Advanced"
}