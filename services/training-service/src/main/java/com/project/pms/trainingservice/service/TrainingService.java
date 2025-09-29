package com.project.pms.trainingservice.service;

import com.project.pms.trainingservice.entity.Course;
import com.project.pms.trainingservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {

    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
}