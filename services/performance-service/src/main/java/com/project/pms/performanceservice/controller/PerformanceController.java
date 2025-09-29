package com.project.pms.performanceservice.controller;

import com.project.pms.performanceservice.entity.Goal;
import com.project.pms.performanceservice.entity.PerformanceReview;
import com.project.pms.performanceservice.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @PostMapping("/reviews")
    public ResponseEntity<PerformanceReview> createReview(@RequestBody PerformanceReview review) {
        return ResponseEntity.ok(performanceService.saveReview(review));
    }

    @GetMapping("/reviews/employee/{employeeId}")
    public ResponseEntity<List<PerformanceReview>> getReviews(@PathVariable Long employeeId) {
        return ResponseEntity.ok(performanceService.getReviewsForEmployee(employeeId));
    }

    @PostMapping("/goals")
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) {
        return ResponseEntity.ok(performanceService.saveGoal(goal));
    }

    @GetMapping("/goals/employee/{employeeId}")
    public ResponseEntity<List<Goal>> getGoals(@PathVariable Long employeeId) {
        return ResponseEntity.ok(performanceService.getGoalsForEmployee(employeeId));
    }
}