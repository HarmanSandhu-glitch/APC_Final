package com.project.pms.documentservice.repository;

import com.project.pms.documentservice.entity.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends MongoRepository<Document, String> {};