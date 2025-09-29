package com.project.pms.organizationservice.repository;

import com.project.pms.organizationservice.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {}
