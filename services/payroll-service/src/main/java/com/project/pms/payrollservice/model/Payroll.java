package com.project.pms.payrollservice.model;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name = "payrolls")
@Data
public class Payroll {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long payrollId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "employee_id", nullable = false)
  private Employee employee;

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
