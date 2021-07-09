package com.example.userprofile.output;

import com.example.userprofile.domain.UserProfile;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

interface UserProfileRepository extends ReactiveCrudRepository<UserProfile,Long> {

}
