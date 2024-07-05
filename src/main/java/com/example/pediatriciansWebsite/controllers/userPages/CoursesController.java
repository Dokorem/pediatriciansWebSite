package com.example.pediatriciansWebsite.controllers.userPages;

import com.example.pediatriciansWebsite.models.courses.CourseUserResponseModel;
import com.example.pediatriciansWebsite.services.courses.CourseUserResponsesService;
import com.example.pediatriciansWebsite.services.courses.CoursesPostElementService;
import com.example.pediatriciansWebsite.services.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class CoursesController {

    private final CourseUserResponsesService responsesService;
    private final CoursesPostElementService coursePostService;
    private final UserService userService;

    @GetMapping("/courses")
    public String coursesPage(Model model, Principal principal) {
        model.addAttribute("user", userService.findUserByPrincipal(principal));
        model.addAttribute("coursesList", coursePostService.findAllCourses());

        return "userPages/coursesPage";
    }

    @PostMapping("/courses/sendResponseOnCourse/{id}")
    public String sendResponseOnCourse(@PathVariable(name = "id") Long id,
            CourseUserResponseModel response)
    {

        responsesService.addResponse(id, response);

        return "redirect:/courses";
    }

}
