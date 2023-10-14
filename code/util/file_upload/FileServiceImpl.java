package com.example.demo.file_upload;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;


@Service
@Slf4j
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {


    @Value("${upload.dir}")
    public String uploadDir;

    @Override
    public String uploadFiles(MultipartFile file) {
        Path copyLocation;

        String fileName = file.getOriginalFilename();
        copyLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(Objects.requireNonNull(fileName)));

        try {
            Files.copy(file.getInputStream(), copyLocation);
            return copyLocation.toString();
        } catch (FileAlreadyExistsException e) {
            String[] arr = fileName.split("\\.");
            String finalFileName = arr[0] + "_" + System.currentTimeMillis() + "." + arr[1];
            copyLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(finalFileName));

            try {
                Files.copy(file.getInputStream(), copyLocation);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return copyLocation.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not store file " + file.getOriginalFilename() + ". Please try again!");
        }


    }
}
