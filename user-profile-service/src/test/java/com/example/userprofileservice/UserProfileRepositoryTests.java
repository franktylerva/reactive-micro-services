package com.example.userprofileservice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataR2dbcTest
public class UserProfileRepositoryTests {

    @Autowired
    private UserProfileRepository repository;

    @BeforeEach
    public void setup() {
        Hooks.onOperatorDebug();
    }

    @Test
    void testSavingUserProfiles() {

        UserProfile profile = new UserProfile();
        profile.setUsername("Frank Tyler");
        profile.setEmail("franktylerva@gmail.com");
        profile.setBirthDate(LocalDate.of(1967, 10, 26));

        repository.save(profile).subscribe();

        UserProfile savedProfile = repository
                .findById(1L).block();

        System.out.println( profile.toString() );
        System.out.println( savedProfile.toString() );

        assertEquals( profile, savedProfile );
    }
}
