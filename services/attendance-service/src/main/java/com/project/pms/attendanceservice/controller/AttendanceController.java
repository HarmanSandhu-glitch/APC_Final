package com.project.pms.attendanceservice.controller;

import com.project.pms.attendanceservice.entity.Attendance;
import com.project.pms.attendanceservice.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    public ResponseEntity<Attendance> markAttendance(@RequestBody Attendance attendance) {
        return ResponseEntity.ok(attendanceService.saveAttendance(attendance));
    }
}