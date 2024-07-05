package com.example.pediatriciansWebsite.services;

import com.example.pediatriciansWebsite.models.ConsultationModel;
import com.example.pediatriciansWebsite.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    public ConsultationModel findById(Long id) {
        return consultationRepository.findById(id).orElseThrow();
    }

    public List<ConsultationModel> findAll() {
        return consultationRepository.findAll();
    }

    public void addConsultation(ConsultationModel consultation) {
        consultationRepository.save(consultation);
    }

}
