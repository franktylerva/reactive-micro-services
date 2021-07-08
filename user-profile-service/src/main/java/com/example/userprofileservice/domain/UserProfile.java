package com.example.userprofileservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
public class UserProfile {

    @Id
    Long id;
    String username;
    String email;
    LocalDate birthDate;
}
