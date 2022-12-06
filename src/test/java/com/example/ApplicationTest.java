package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Base64;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplicationTest {

  @Autowired
  private WebTestClient client;

  @Test
  void fullTest() {
    client.get()
            .uri("/people")
            .header(ACCEPT, APPLICATION_JSON_VALUE)
            .header(AUTHORIZATION, "Basic " + Base64.getEncoder().encodeToString("user:pass".getBytes()))
            .exchange()
            .expectBody().jsonPath("$").value(hasSize(1));
  }
}
