package com.project.pms.reportingservice.client;

import com.project.pms.reportingservice.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "employee-service")
public interface EmployeeClient {

    @GetMapping("/api/v1/employees")
    List<Employee> getAllEmployees();
}