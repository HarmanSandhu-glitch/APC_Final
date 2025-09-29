package com.project.pms.attendanceservice.service;

import com.project.pms.attendanceservice.entity.Attendance;
import com.project.pms.attendanceservice.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }
}