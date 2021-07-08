package com.example.userprofileservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.time.LocalDate;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserProfileController {

    final UserProfileService userProfileService;

    @GetMapping("/api/hello")
    public Mono<String> hello(Principal principal) {
        log.info( "Principal is {}.", principal.getName() );
        return Mono.just("Hello World!");
    }

    @GetMapping("/api/user-profiles")
    public Flux<UserProfile> allUserProfile() {
        return userProfileService.getAllUserProfiles();
    }

}
