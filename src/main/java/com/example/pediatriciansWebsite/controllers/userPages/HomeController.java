package com.example.pediatriciansWebsite.controllers.userPages;

import com.example.pediatriciansWebsite.models.UserModel;
import com.example.pediatriciansWebsite.services.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class HomeController {

    private UserService userService;

    @GetMapping("/")
    public String getHomePage(Principal principal, Model model) {
        UserModel user = userService.findUserByPrincipal(principal);
        model.addAttribute("user", user);
        return "userPages/homePage";
    }

}
