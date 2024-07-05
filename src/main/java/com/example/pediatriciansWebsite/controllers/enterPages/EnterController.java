package com.example.pediatriciansWebsite.controllers.enterPages;

import com.example.pediatriciansWebsite.models.UserModel;
import com.example.pediatriciansWebsite.services.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class EnterController {

    private UserService userService;

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            Model model)
    {

        if(error != null) {
            model.addAttribute("errorMessage", "Неправильный email или пароль");
        }

        return "enterPages/loginPage";
    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "enterPages/registrationPage";
    }

    @PostMapping("/registration")
    public String addUser(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "confirmPassword") String confirmPassword,
            @RequestParam(name = "username") String username,
            Model model
    ) {
        if (email != null && password != null && confirmPassword != null && username != null) {
            if (!password.equals(confirmPassword)) {
                model.addAttribute("errorMessage", "Пароли не совпадают!");
                model.addAttribute("email", email);
                model.addAttribute("username", username);

                return "enterPages/registrationPage";
            }

            if(!userService.createUser(new UserModel(email, password, username, "ROLE_USER", true))) {
                model.addAttribute("errorMessage", "Пользователь с такой почтой уже существует!");
                return "enterPages/registrationPage";
            }
        }

        return "redirect:/";
    }



}
