package com.example.saveFile.service;

import com.example.saveFile.model.File;

public interface FileService {
    File saveFile(File file);
    File findById(int id);
}
