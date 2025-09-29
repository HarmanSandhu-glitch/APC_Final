package com.project.pms.leaveservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Table(name = "leaves")
@Data
public class Leave {

  public enum LeaveStatus {
    PENDING,
    APPROVED,
    REJECTED
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long leaveId;

  @ManyToOne
  @JoinColumn(name = "employee_id", nullable = false)
  private Employee employee;

  @Column(nullable = false)
  private LocalDate startDate;

  @Column(nullable = false)
  private LocalDate endDate;

  private String reason;

  @Enumerated(EnumType.STRING)
  private LeaveStatus status = LeaveStatus.PENDING;
}
