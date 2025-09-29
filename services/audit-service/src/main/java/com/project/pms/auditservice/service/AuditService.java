package com.project.pms.auditservice.service;

import com.project.pms.auditservice.entity.AuditLog;
import com.project.pms.auditservice.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    public AuditLog logEvent(String serviceName, String eventType, String details) {
        AuditLog log = new AuditLog();
        log.setServiceName(serviceName);
        log.setEventType(eventType);
        log.setDetails(details);
        log.setTimestamp(LocalDateTime.now());
        return auditRepository.save(log);
    }

    public List<AuditLog> getAllLogs() {
        return auditRepository.findAll();
    }
}