package com.project.pms.documentservice.controller;

import com.project.pms.documentservice.entity.Document;
import com.project.pms.documentservice.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("employeeId") Long employeeId) {
        try {
            Document document = documentService.saveFile(file, employeeId);
            // Use getDocumentId() to match the field in your Document entity
            return ResponseEntity.ok("File uploaded successfully with ID: " + document.getDocumentId());
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Could not upload the file: " + e.getMessage());
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        Document document = documentService.getFile(id);
        if (document == null) {
            return ResponseEntity.notFound().build();
        }
        // Correctly call the methods that exist on your Document entity
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getDocumentTitle() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM) // A generic content type
                .body(document.getDocumentData());
    }
}