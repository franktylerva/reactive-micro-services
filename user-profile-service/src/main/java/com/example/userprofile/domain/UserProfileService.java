package com.example.userprofile.domain;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserProfileService {
    public Flux<UserProfile> getAllUserProfiles();
    public Mono<UserProfile> createUserProfile(UserProfile profile);
}
