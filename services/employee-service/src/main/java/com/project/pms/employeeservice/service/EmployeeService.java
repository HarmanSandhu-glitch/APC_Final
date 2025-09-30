package com.project.pms.employeeservice.service;

import com.project.pms.employeeservice.client.OrganizationClient;
import com.project.pms.employeeservice.dto.EmployeeResponse;
import com.project.pms.employeeservice.entity.Employee;
import com.project.pms.employeeservice.model.Department;
import com.project.pms.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private OrganizationClient organizationClient;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public EmployeeResponse getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        if (employee != null) {
            Department department = organizationClient.getDepartmentById(employee.getDepartmentId());

            EmployeeResponse employeeResponse = new EmployeeResponse();
            employeeResponse.setId(employee.getId());
            employeeResponse.setFirstName(employee.getFirstName());
            employeeResponse.setLastName(employee.getLastName());
            employeeResponse.setEmail(employee.getEmail());
            employeeResponse.setDepartment(department);
            employeeResponse.setPositionId(employee.getPositionId());
            return employeeResponse;
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}