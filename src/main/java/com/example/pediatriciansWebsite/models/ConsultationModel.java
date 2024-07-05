package com.example.pediatriciansWebsite.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@Table(name = "consultations")
@NoArgsConstructor
public class ConsultationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "userComment")
    private String userComment;

    @Column(name = "dateOfCreation")
    private String dateOfCreation;

    public ConsultationModel(String fullName, String phoneNumber, String userComment) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.userComment = userComment;
    }

    @PrePersist
    private void init() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateOfCreation = formatter.format(new Date());
    }

}
