package com.project.pms.reportingservice.model;

import lombok.Data;
import java.util.Date;

@Data
public class Employee {
    private Long employeeId;
    private String employeeName;
    private String employeeEmail;
    private Date employeeJoinDate;
    private Long positionId;
    private Long departmentId;
}