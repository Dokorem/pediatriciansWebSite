package com.example.pediatriciansWebsite.controllers.userPages;

import com.example.pediatriciansWebsite.models.ConsultationModel;
import com.example.pediatriciansWebsite.services.ConsultationService;
import com.example.pediatriciansWebsite.services.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class ConsultationsController {

    private final UserService userService;
    private final ConsultationService consultationService;

    @GetMapping("/consultations")
    public String consultationsPage(Principal principal, Model model) {

        model.addAttribute("user", userService.findUserByPrincipal(principal));

        return "userPages/consultationsPage";
    }

    @PostMapping("/consultations")
    public String consultationsPost(ConsultationModel consultation) {

        consultationService.addConsultation(consultation);

        return "redirect:/consultations";
    }

}
