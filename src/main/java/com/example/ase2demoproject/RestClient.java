package com.example.ase2demoproject;

import com.example.ase2demoproject.domain.Person;
import com.example.ase2demoproject.utils.MyLogger;
import org.springframework.web.client.RestTemplate;

/**
 * Backend must be running
 */
public class RestClient implements MyLogger {
    public static void main(String[] args) {
        new RestClient().start();
    }

    public void start() {
        final String uri = "http://localhost:8080/api/persons/1";
        RestTemplate restTemplate = new RestTemplate();
        Person result = restTemplate.getForObject(uri, Person.class);
        getLogger().info(result.toString());
    }
}
