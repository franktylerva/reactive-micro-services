package com.example.userprofileservice;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserProfileRepository extends ReactiveCrudRepository<UserProfile,Long> {

}
