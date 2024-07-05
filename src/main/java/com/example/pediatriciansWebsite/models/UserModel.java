package com.example.pediatriciansWebsite.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Users")
@NoArgsConstructor
public class UserModel {

    public UserModel(String email, String password, String name, String role, boolean isActive) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.isActive = isActive;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    @Column(name = "dateOfBirth")
    private String dateOfBirth;

    @Column(name = "isActive")
    private boolean isActive;

}
