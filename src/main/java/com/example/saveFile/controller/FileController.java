package com.example.saveFile.controller;

import com.example.saveFile.model.File;
import com.example.saveFile.service.FileService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile uploadedFile) {
        File file = new File();
        try {
            file.setName(uploadedFile.getOriginalFilename());
            file.setType(uploadedFile.getContentType());
            file.setData(uploadedFile.getBytes());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }

        fileService.saveFile(file);
        return ResponseEntity.ok("http://localhost:8080/files/" + file.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable int id) {
        File file = fileService.findById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getName() + "\"")
                .body(file.getData());
    }
}
