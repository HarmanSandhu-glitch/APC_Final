package com.project.pms.documentservice.service;

import com.project.pms.documentservice.entity.Document;
import com.project.pms.documentservice.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document saveFile(MultipartFile file, Long employeeId) throws IOException {
        Document document = new Document();
        document.setEmployeeId(employeeId); // Set the employee ID
        document.setDocumentTitle(file.getOriginalFilename());
        document.setDocumentData(file.getBytes());
        return documentRepository.save(document);
    }

    public Document getFile(Long id) {
        return documentRepository.findById(id).orElse(null);
    }
}