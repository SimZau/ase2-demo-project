package com.example.ase2demoproject.web.rest;

import com.example.ase2demoproject.domain.Person;
import com.example.ase2demoproject.repository.PersonRepository;
import com.example.ase2demoproject.web.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/persons")
public class PersonRestController {
    private final PersonRepository personRepository;

    @Autowired
    public PersonRestController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personRepository.findById(id)
                .orElseThrow(()
                        -> new PersonNotFoundException("Get not successful: person with id=" + id
                        + " not found"));
    }
}
