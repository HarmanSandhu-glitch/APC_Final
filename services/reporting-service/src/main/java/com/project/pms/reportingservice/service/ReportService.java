package com.project.pms.reportingservice.service;

import com.project.pms.reportingservice.client.EmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private EmployeeClient employeeClient;

    public byte[] generatePdfReport() {
        // Logic to generate PDF report using employeeClient.getAllEmployees()
        return new byte[0];
    }

    public byte[] generateExcelReport() {
        // Logic to generate Excel report using employeeClient.getAllEmployees()
        return new byte[0];
    }
}