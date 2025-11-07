package com.example.saveFile.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

    @Entity
    public class File {


        private int id;
        private LocalDateTime createdAt;
        private String name;
        private byte[] data;
        private String type;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @CreationTimestamp
        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public byte[] getData() {
            return data;
        }

        public void setData(byte[] data) {
            this.data = data;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }


