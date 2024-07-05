package com.example.pediatriciansWebsite.repositories;

import com.example.pediatriciansWebsite.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByEmail(String email);

}
