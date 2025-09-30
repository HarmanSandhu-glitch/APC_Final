package com.project.pms.employeeservice.dto;

import com.project.pms.employeeservice.model.Department;
import lombok.Data;

@Data
public class EmployeeResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Department department;
    private Long positionId;
}