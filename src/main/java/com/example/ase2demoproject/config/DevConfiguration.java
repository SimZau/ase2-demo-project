package com.example.ase2demoproject.config;

import com.example.ase2demoproject.domain.Person;
import com.example.ase2demoproject.repository.PersonRepository;
import com.example.ase2demoproject.utils.MyLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Sort;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
@Profile("dev")
//@ConditionalOnClass(name = {"org.h2.Driver"})
public class DevConfiguration implements MyLogger {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    @Qualifier("felixMuster")
    Person felixMuster;

    @Autowired
    @Qualifier("maxMustermann")
    Person maxMustermann;

    public DevConfiguration() {
        getLogger().info("Dev Configuration Class");
    }

    @PostConstruct
    public void createPersonData() {
        personRepository.save(felixMuster);
        personRepository.save(maxMustermann);
        getLogger().debug("Person felixMuster and maxMustermann saved to DB");

        List<Person> persons = personRepository.findQueryByLastName("Mustermann");
        persons.forEach(person -> getLogger().debug("person.toString() = " + person.toString()));
        personRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName")).forEach(person -> {
            personRepository.findById(person.getId())
                    .ifPresent(p -> getLogger().debug("person.toString() = " + p.toString()));
        });
    }
}
