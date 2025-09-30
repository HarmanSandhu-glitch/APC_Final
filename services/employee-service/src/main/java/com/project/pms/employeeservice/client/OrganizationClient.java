package com.project.pms.employeeservice.client;

import com.project.pms.employeeservice.model.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "organization-service")
public interface OrganizationClient {

    @GetMapping("/department/{id}")
    Department getDepartmentById(@PathVariable("id") Long id);
}