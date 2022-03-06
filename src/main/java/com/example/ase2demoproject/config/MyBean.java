package com.example.ase2demoproject.config;

import com.example.ase2demoproject.domain.Person;
import com.example.ase2demoproject.utils.MyLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements CommandLineRunner, MyLogger {

    MyComponent myComponent;

    @Autowired
    @Qualifier("felixMuster")
    Person felixMuster;

    @Autowired
    @Qualifier("maxMustermann")
    Person maxMustermann;

    @Autowired
    public MyBean(MyComponent myComponent) {
        this.myComponent = myComponent;
    }

    @Override
    public void run(String... args) {
        myComponent.hello();
        getLogger().info("getTestValue = " + myComponent.getTestValue());
        getLogger().debug("Felix Muster Test " + felixMuster.toString());
        getLogger().debug("Max Mustermann Test " + maxMustermann.toString());
    }
}
