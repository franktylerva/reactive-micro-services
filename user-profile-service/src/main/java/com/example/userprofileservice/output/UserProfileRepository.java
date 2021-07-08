package com.example.userprofileservice.output;

import com.example.userprofileservice.domain.UserProfile;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserProfileRepository extends ReactiveCrudRepository<UserProfile,Long> {

}
