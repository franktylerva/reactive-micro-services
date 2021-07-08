package com.example.userprofileservice;

import reactor.core.publisher.Flux;

public interface UserProfileService {
    public Flux<UserProfile> getAllUserProfiles();
}
