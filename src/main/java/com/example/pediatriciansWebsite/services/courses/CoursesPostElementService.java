package com.example.pediatriciansWebsite.services.courses;

import com.example.pediatriciansWebsite.impl.ImageImpl;
import com.example.pediatriciansWebsite.models.courses.CoursesPostElementModel;
import com.example.pediatriciansWebsite.repositories.courses.CoursePostElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CoursesPostElementService {

    @Autowired
    private CoursePostElementRepository repository;
    @Autowired
    private ImageImpl impl;

    public CoursesPostElementModel findCourseById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<CoursesPostElementModel> findAllCourses() {
        return repository.findAll();
    }

    public void deleteCourseById(Long id) {
        CoursesPostElementModel currentCourse = findCourseById(id);
        repository.delete(currentCourse);
        impl.delete(currentCourse.getImagePath());
    }

    public void saveCoursePost(CoursesPostElementModel postElement) {
        repository.save(postElement);
    }

    public void saveCoursePost(CoursesPostElementModel postElement, byte[] image) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String imagePath = "courses/" + formatter.format(new Date()) + ".jpg";
        postElement.setImagePath(imagePath);
        impl.write(imagePath, image);
        repository.save(postElement);
    }

}
