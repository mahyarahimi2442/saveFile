package com.example.saveFile.repository;

import com.example.saveFile.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,Integer> {
}
