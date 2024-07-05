package com.example.pediatriciansWebsite.repositories.courses;

import com.example.pediatriciansWebsite.models.courses.CourseUserResponseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseUserResponsesRepository extends JpaRepository<CourseUserResponseModel, Long> {
}
