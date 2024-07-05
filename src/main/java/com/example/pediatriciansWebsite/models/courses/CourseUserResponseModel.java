package com.example.pediatriciansWebsite.models.courses;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "userResponsesOnCourses")
@NoArgsConstructor
public class CourseUserResponseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "responseUsername")
    private String responseUsername;

    @Column(name = "responseUserNumber")
    private String responseUserNumber;

    @Column(name = "responseUserComment")
    private String responseUserComment;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private CoursesPostElementModel coursePost;

    public CourseUserResponseModel(String responseUsername, String responseUserNumber, String responseUserComment) {
        this.responseUsername = responseUsername;
        this.responseUserNumber = responseUserNumber;
        this.responseUserComment = responseUserComment;
    }

    @Override
    public String toString() {
        return "CourseUserResponseModel{" +
                "id=" + id +
                ", responseUsername='" + responseUsername + '\'' +
                ", responseUserNumber='" + responseUserNumber + '\'' +
                ", responseUserComment='" + responseUserComment + '\'' +
                ", coursePost=" + coursePost +
                '}';
    }
}
