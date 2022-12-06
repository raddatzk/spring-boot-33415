package com.example.people;

import com.example.api.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PeopleController implements Api {

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  public List<Person> getPeople() {
    return List.of(new Person("firstname", "lastname"));
  }
}
