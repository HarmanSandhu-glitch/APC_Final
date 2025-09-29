package com.project.pms.performanceservice.service;

import com.project.pms.performanceservice.entity.Goal;
import com.project.pms.performanceservice.entity.PerformanceReview;
import com.project.pms.performanceservice.repository.GoalRepository;
import com.project.pms.performanceservice.repository.PerformanceReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceReviewRepository reviewRepository;

    @Autowired
    private GoalRepository goalRepository;

    public PerformanceReview saveReview(PerformanceReview review) {
        return reviewRepository.save(review);
    }

    public List<PerformanceReview> getReviewsForEmployee(Long employeeId) {
        return reviewRepository.findByEmployeeId(employeeId);
    }

    public Goal saveGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public List<Goal> getGoalsForEmployee(Long employeeId) {
        return goalRepository.findByEmployeeId(employeeId);
    }
}