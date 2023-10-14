package com.example.demo.file_upload;

import org.springframework.web.multipart.MultipartFile;


public interface FileService {
    String uploadFiles(MultipartFile file);
}