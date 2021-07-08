package com.example.userprofileservice.output;

import com.example.userprofileservice.domain.UserProfile;
import com.example.userprofileservice.domain.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    final UserProfileRepository userProfileRepository;

    @Override
    public Flux<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    @Override
    public Mono<UserProfile> createUserProfile(UserProfile profile) {
        return userProfileRepository.save( profile );
    }
}
