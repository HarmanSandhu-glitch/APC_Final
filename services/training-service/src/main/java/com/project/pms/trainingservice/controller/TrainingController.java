package com.project.pms.trainingservice.controller;

import com.project.pms.trainingservice.entity.Course;
import com.project.pms.trainingservice.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/training")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return ResponseEntity.ok(trainingService.saveCourse(course));
    }
}