package com.example.pediatriciansWebsite.repositories.courses;

import com.example.pediatriciansWebsite.models.courses.CoursesPostElementModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursePostElementRepository extends JpaRepository<CoursesPostElementModel, Long> {
}
