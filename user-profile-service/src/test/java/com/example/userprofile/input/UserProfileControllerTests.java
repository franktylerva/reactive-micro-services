package com.example.userprofile.input;

import com.example.userprofile.domain.UserProfile;
import com.example.userprofile.domain.UserProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockJwt;

@WebFluxTest(controllers = {UserProfileController.class})
class UserProfileControllerTests {

	@Autowired
	private WebTestClient client;

	@MockBean
	private UserProfileService userProfileService;

	private Flux<UserProfile> userProfiles;

	@BeforeEach
	void setup() {

		UserProfile p1 = new UserProfile();
		p1.setId(1L);
		p1.setUsername("p1");
		p1.setEmail("p1@gmail.com");
		p1.setBirthDate( LocalDate.of(1984,1,1));

		UserProfile p2 = new UserProfile();
		p2.setId(1L);
		p2.setUsername("p2");
		p2.setEmail("p2@gmail.com");
		p2.setBirthDate( LocalDate.of(1984,1,1));

		userProfiles = Flux.just( p1, p2 );

	}

	@Test
	void shouldReturnAllUserProfiles() {

		Mockito.when(userProfileService.getAllUserProfiles() )
				.thenReturn( userProfiles );

		client.mutateWith(mockJwt())
				.get().uri("/api/user-profiles")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(UserProfile.class)
				.hasSize( userProfiles.count().block().intValue() );
	}

	@Test
	void shouldCreateUserProfile() {

		UserProfile p1 = new UserProfile();
		p1.setId(1L);
		p1.setUsername("p1");
		p1.setEmail("p1@gmail.com");
		p1.setBirthDate( LocalDate.of(1984,1,1));

		Mockito.when(userProfileService.createUserProfile(any(UserProfile.class)))
				.thenReturn(Mono.just(p1));

		client.mutateWith(mockJwt())
				.mutateWith(csrf())
				.post().uri("/api/user-profiles")
				.accept(MediaType.APPLICATION_JSON)
				.bodyValue( p1 )
				.exchange()
				.expectStatus().isCreated()
				.expectHeader().location("/api/user-profiles/1");
	}

}
