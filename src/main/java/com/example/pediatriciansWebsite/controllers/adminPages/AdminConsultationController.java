package com.example.pediatriciansWebsite.controllers.adminPages;

import com.example.pediatriciansWebsite.services.ConsultationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/adminPanel")
public class AdminConsultationController {

    private final ConsultationService service;

    @GetMapping("/consultations")
    public String adminConsultationPage(Model model) {

        model.addAttribute("consultationsList", service.findAll());

        return "adminPages/adminConsultationsPage";
    }



}
