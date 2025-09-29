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

    public Document saveFile(MultipartFile file) throws IOException {
        Document document = new Document();
        document.setFileName(file.getOriginalFilename());
        document.setFileType(file.getContentType());
        document.setData(file.getBytes());
        return documentRepository.save(document);
    }

    public Document getFile(String id) {
        return documentRepository.findById(id).orElse(null);
    }
}