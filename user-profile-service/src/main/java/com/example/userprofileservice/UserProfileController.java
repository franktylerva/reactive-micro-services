package com.example.userprofileservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
@Slf4j
public class UserProfileController {

    @GetMapping("/api/hello")
    public Mono<String> hello(Principal principal) {
        log.info( "Principal is {}.", principal.getName() );
        return Mono.just("Hello World!");
    }
}
