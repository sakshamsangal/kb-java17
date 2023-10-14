package com.example.demo.file_upload;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
public class FileUploadController {
    private final FileService fileService;

    // upload:
    // dir: D:/Temporary/upload
    @PostMapping("/uf")
    public ResponseEntity<List<String>> uploadFiles(@RequestParam("files") MultipartFile[] files) {

        List<String> list = new ArrayList<>();
        Arrays.stream(files).forEach(file -> {
            String url = fileService.uploadFiles(file);
            list.add(url);
        });
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}