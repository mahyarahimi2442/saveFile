package com.example.saveFile.service;

import com.example.saveFile.model.File;
import com.example.saveFile.repository.FileRepository;
import org.springframework.stereotype.Service;

     @Service
      public class FileServiceImpl implements FileService {

        private final FileRepository fileRepository;

        public FileServiceImpl(FileRepository fileRepository) {
            this.fileRepository = fileRepository;
        }

        @Override
        public File saveFile(File file) {
            return fileRepository.save(file);
        }

        @Override
        public File findById(int id) {
            return fileRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("File not found with id: " + id));
        }
    }

