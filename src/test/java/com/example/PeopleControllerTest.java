package com.example;

import com.example.people.PeopleController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Base64;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PeopleController.class)
@Import(SecurityConfig.class)
public class PeopleControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  void getPeople() throws Exception {
    mvc.perform(get("/people")
            .header(ACCEPT, APPLICATION_JSON_VALUE)
            .header(AUTHORIZATION, "Basic " + Base64.getEncoder().encodeToString("user:pass".getBytes()))
    ).andExpect(status().isOk());
  }

}
