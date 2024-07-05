package com.example.pediatriciansWebsite.models.courses;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "coursesPosts")
@NoArgsConstructor
public class CoursesPostElementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nameOfTheCourse")
    private String nameOfTheCourse;

    @Column(name = "descriptionOfTheCourse", length = 5000)
    private String descriptionOfTheCourse;

    @Column(name = "priceOfTheCourse")
    private double priceOfTheCourse;

    @Column(name = "imagePath")
    private String imagePath;

    @Column(name = "dateOfCreation")
    private String dateOfCreation;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "coursePost")
    private List<CourseUserResponseModel> responsesList = new ArrayList<>();

    public CoursesPostElementModel(String nameOfTheCourse, String descriptionOfTheCourse, double priceOfTheCourse, String imagePath) {
        this.nameOfTheCourse = nameOfTheCourse;
        this.descriptionOfTheCourse = descriptionOfTheCourse;
        this.priceOfTheCourse = priceOfTheCourse;
        this.imagePath = imagePath;
    }

    @PrePersist
    private void init() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        dateOfCreation = formatter.format(new Date());
    }

}
