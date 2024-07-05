package com.example.pediatriciansWebsite.services.courses;

import com.example.pediatriciansWebsite.models.courses.CourseUserResponseModel;
import com.example.pediatriciansWebsite.models.courses.CoursesPostElementModel;
import com.example.pediatriciansWebsite.repositories.courses.CoursePostElementRepository;
import com.example.pediatriciansWebsite.repositories.courses.CourseUserResponsesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseUserResponsesService {

    @Autowired
    private CourseUserResponsesRepository responsesRepository;
    @Autowired
    private CoursesPostElementService coursePostService;


    public CourseUserResponseModel findResponseById(Long id) {
        return responsesRepository.findById(id).orElseThrow();
    }

    public List<CourseUserResponseModel> findAllResponsesAtCoursePost(Long coursePostId) {
        return coursePostService.findCourseById(coursePostId).getResponsesList();
    }

    public void addResponse(Long coursePostId, CourseUserResponseModel response) {

        CoursesPostElementModel currentPost = coursePostService.findCourseById(coursePostId);
        response.setCoursePost(currentPost);

        List<CourseUserResponseModel> currentResponsesList = currentPost.getResponsesList();
        currentResponsesList.add(response);
        currentPost.setResponsesList(currentResponsesList);

        coursePostService.saveCoursePost(currentPost);

    }

}
