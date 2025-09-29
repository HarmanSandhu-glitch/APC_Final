package com.project.pms.payrollservice.client;

import com.project.pms.payrollservice.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

@FeignClient(name = "employee-service")
public interface EmployeeClient {

    @GetMapping("/api/v1/employees/{id}")
    Optional<Employee> getEmployeeById(@PathVariable("id") Long id);
}