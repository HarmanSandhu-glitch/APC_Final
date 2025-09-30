package com.project.pms.employeeservice.service;

import com.project.pms.employeeservice.client.OrganizationClient;
import com.project.pms.employeeservice.dto.EmployeeResponse;
import com.project.pms.employeeservice.entity.Employee;
import com.project.pms.employeeservice.model.Department;
import com.project.pms.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId; // <-- Import ZoneId
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private OrganizationClient organizationClient;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            return null;
        }

        Department department = organizationClient.getDepartmentById(employee.getDepartmentId());

        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmployeeId(employee.getEmployeeId());
        employeeResponse.setEmployeeName(employee.getEmployeeName());
        employeeResponse.setEmployeeEmail(employee.getEmployeeEmail());

        employeeResponse.setEmployeeJoinDate(employee.getEmployeeJoinDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        employeeResponse.setPositionId(employee.getPositionId());
        employeeResponse.setDepartment(department);

        return employeeResponse;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}