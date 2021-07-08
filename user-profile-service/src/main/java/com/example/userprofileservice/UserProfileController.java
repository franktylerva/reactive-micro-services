package com.example.userprofileservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.security.Principal;
import java.time.LocalDate;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserProfileController {

    final UserProfileService userProfileService;

    @GetMapping("/api/user-profiles")
    public Flux<UserProfile> allUserProfile() {
        return userProfileService.getAllUserProfiles();
    }

    @PostMapping("/api/user-profiles")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseEntity<UserProfile>> createUserProfile(UserProfile profile ) {
        return Mono.just(profile)
                .flatMap( p -> userProfileService.createUserProfile(profile) )
                .map(p -> ResponseEntity
                        .created( URI.create("/api/user-profiles/" + p.getId() ) )
                        .contentType( MediaType.APPLICATION_JSON )
                        .build() );
    }
}
