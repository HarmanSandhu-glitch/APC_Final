package com.project.pms.documentservice.repository;

import com.project.pms.documentservice.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Change the ID type from String to Long to match your Document entity
public interface DocumentRepository extends JpaRepository<Document, Long> {
}