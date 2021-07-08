package com.example.userprofileservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockJwt;

@WebFluxTest(controllers = {UserProfileController.class})
class UserProfileControllerTests {

	@Autowired
	private WebTestClient client;

	@MockBean
	private UserProfileService userProfileService;

	@Test
	void testHello() {

		client.mutateWith(mockJwt())
				.get().uri("/api/hello")
				.accept(MediaType.TEXT_PLAIN)
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo("Hello World!");
	}
}
