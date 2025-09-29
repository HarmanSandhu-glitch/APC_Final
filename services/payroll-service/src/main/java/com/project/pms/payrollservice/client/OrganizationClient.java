package com.project.pms.payrollservice.client;

import com.project.pms.payrollservice.model.Position;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "organization-service")
public interface OrganizationClient {

    @GetMapping("/api/v1/positions/{id}")
    Position getPositionById(@PathVariable("id") Long id);
}
