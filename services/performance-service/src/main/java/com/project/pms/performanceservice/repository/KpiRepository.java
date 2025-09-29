package com.project.pms.performanceservice.repository;

import com.project.pms.performanceservice.entity.Kpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KpiRepository extends JpaRepository<Kpi, Long> {
}