package com.project.pms.documentservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "documents")
@Data
public class Document {
    @Id
    private String id;
    private String fileName;
    private String fileType;
    private byte[] data;
}