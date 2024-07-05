package com.example.pediatriciansWebsite.controllers.adminPages;

import com.example.pediatriciansWebsite.models.courses.CoursesPostElementModel;
import com.example.pediatriciansWebsite.services.courses.CourseUserResponsesService;
import com.example.pediatriciansWebsite.services.courses.CoursesPostElementService;
import com.example.pediatriciansWebsite.services.users.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@AllArgsConstructor
@RequestMapping("/adminPanel")
public class AdminCoursesController {

    private final CoursesPostElementService coursePostService;
    private final UserService userService;

    private static final String HOME_PAGE = "/adminPanel/coursesManage";

    @GetMapping("/coursesManage")
    public String courseManagePage(Model model, Principal principal) {
        model.addAttribute("user", userService.findUserByPrincipal(principal));
        model.addAttribute("coursesList", coursePostService.findAllCourses());

        return "adminPages/courses/coursesManagePage";
    }

    @PostMapping("/coursesManage/addCourse")
    public String addCoursePostElement(@RequestParam(name = "courseImage") MultipartFile courseImage,
                                       CoursesPostElementModel coursePost) throws IOException
    {

        coursePostService.saveCoursePost(coursePost, courseImage.getBytes());

        return "redirect:" + HOME_PAGE;
    }

    @GetMapping("/coursesManage/coursesResponses/{id}")
    public String courseResponsesPage(@PathVariable(name = "id") Long id, Model model, Principal principal) {

        model.addAttribute("user", userService.findUserByPrincipal(principal));
        model.addAttribute("responsesList", coursePostService.findCourseById(id).getResponsesList());

        return "adminPages/courses/courseResponsesPage";
    }



}
