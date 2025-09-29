package com.project.pms.auditservice.controller;

import com.project.pms.auditservice.entity.AuditLog;
import com.project.pms.auditservice.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/audit")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @PostMapping("/log")
    public ResponseEntity<AuditLog> logEvent(@RequestBody AuditLog auditLog) {
        return ResponseEntity.ok(auditService.logEvent(auditLog.getServiceName(), auditLog.getEventType(), auditLog.getDetails()));
    }

    @GetMapping("/logs")
    public ResponseEntity<List<AuditLog>> getAllLogs() {
        return ResponseEntity.ok(auditService.getAllLogs());
    }
}