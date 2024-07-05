package com.example.pediatriciansWebsite.impl;

import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@RestController
public class ImageImpl {

    private static final String MAIN_DIR_PATH = "/var/images/";

    public void write(String imagePath, byte[] image) {
        String path = MAIN_DIR_PATH + imagePath;

        try{
            Path dirPath = Paths.get(path).getParent();
            if(!Files.exists(dirPath)) {
                Files.createDirectory(dirPath);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Path filePath = Paths.get(path);
            Files.write(filePath, image, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] read(String imagePath) {
        Path path = Paths.get(MAIN_DIR_PATH + imagePath);
        try {
            if(Files.exists(path)) {
                return Files.readAllBytes(path);
            }
            else {
                throw new RuntimeException("File is not exists! File error path is - " + imagePath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Method read in class ImageImpl threw IOException - " + e);
        }
    }

    public void delete(String imagePath) {
        Path path = Paths.get(MAIN_DIR_PATH + imagePath);
        try {
            if(Files.exists(path)) {
                Files.delete(path);
            } else {
                throw new RuntimeException("This file doesn't exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
