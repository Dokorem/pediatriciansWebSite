package com.example.pediatriciansWebsite.repositories;

import com.example.pediatriciansWebsite.models.ConsultationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<ConsultationModel, Long> {
}
