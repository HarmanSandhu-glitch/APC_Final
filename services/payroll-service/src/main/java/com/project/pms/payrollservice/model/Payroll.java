package com.project.pms.payrollservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "payrolls")
@Data
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payrollId;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date payrollPayDate;

    @Column(nullable = false)
    private Double payrollBaseSalary;

    @Column(nullable = false)
    private Double payrollExperienceBonus;

    @Column(nullable = false)
    private Double payrollDeductions;

    @Column(nullable = false)
    private Double payrollTotalPay;
}