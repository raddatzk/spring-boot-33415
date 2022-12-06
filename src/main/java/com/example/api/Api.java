package com.example.api;

import com.example.people.Person;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Generate from openapi generator
 */
public interface Api {

  @GetMapping(
          value = "/people",
          produces = {"application/json"}
  )
  List<Person> getPeople();
}
