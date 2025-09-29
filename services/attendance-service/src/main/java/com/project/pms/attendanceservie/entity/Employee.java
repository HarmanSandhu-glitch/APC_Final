package com.project.pms.employeeservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NotBlank(message = "Employee name cannot be blank")
    @Column(nullable = false)
    private String employeeName;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = true)
    private String employeeEmail;

    @NotNull(message = "Join date is required")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date employeeJoinDate;

    @NotNull(message = "Position ID is required")
    @Column(name = "position_id", nullable = false)
    private Long positionId;

    @NotNull(message = "Department ID is required")
    @Column(name = "department_id", nullable = false)
    private Long departmentId;
}