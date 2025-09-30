package com.project.pms.employeeservice.dto;

import com.project.pms.employeeservice.model.Department;
import lombok.Data;
import java.time.LocalDate;

@Data
public class EmployeeResponse {
    private Long employeeId;
    private String employeeName;
    private String employeeEmail;
    private LocalDate employeeJoinDate;
    private Department department;
    private Long positionId;
}