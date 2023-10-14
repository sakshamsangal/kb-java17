package com.app.template;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileCopy {
    public static void main(String[] args) throws IOException {

        Path src = new File( "temp.txt").toPath();
        Path dst = new File( "tem2.txt").toPath();
        Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
    }
}
