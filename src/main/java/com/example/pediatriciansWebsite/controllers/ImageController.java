package com.example.pediatriciansWebsite.controllers;

import com.example.pediatriciansWebsite.impl.ImageImpl;
import com.example.pediatriciansWebsite.models.courses.CoursesPostElementModel;
import com.example.pediatriciansWebsite.services.courses.CoursesPostElementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/images")
public class ImageController {

    /**
     * Класс создан для передачи изображения, как массива байт в html код
     */

    @Autowired
    private CoursesPostElementService coursesPostElementService;

    @Autowired
    private ImageImpl impl;

    @GetMapping("/courseImage/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> getCoursesImage(@PathVariable(name = "id") Long id) {
        CoursesPostElementModel currentCourse = coursesPostElementService.findCourseById(id);
        byte[] imageBytes = impl.read(currentCourse.getImagePath());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // или другой соответствующий тип MIME, например, IMAGE_PNG

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

}
