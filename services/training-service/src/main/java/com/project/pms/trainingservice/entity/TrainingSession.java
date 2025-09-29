package com.project.pms.trainingservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "training_sessions")
@Data
public class TrainingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long courseId;
    private LocalDateTime schedule;
    private String location;
    private Long instructorId;
}