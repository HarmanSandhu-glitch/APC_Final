package com.project.pms.performanceservice.repository;

import com.project.pms.performanceservice.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByEmployeeId(Long employeeId);
}