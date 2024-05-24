package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


// Defines a Spring configuration class to pre-populate the student data in the application
// @Configuration marks the class a Spring configuration class, providing configuration beans for the application
@Configuration
public class StudentConfig {
    // @Bean declares a method that returns a bean.
    // A bean is a managed object created and controlled by the Spring container. Represents any object that plays a role in application logic.
    // Spring manages the bean's lifecycle, including creation, initialization, configuration, and destruction. This simplifies object lifecycle management and ensures proper resource handling.
    // Beans can have dependencies on other beans. Spring automatically injects these dependencies based on their types, eliminating the need for manual object creation and configuration. This promotes loose coupling and improves code maintainability.
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student andrew = new Student(
                    "Andrew",
                    "andrewng@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 1)
            );

            Student bob = new Student(
                    "Bob",
                    "BobBuilder@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 1)
            );

            // Saves all student objects to the database in a single transaction
            repository.saveAll(
                    List.of(andrew, bob)
            );
        };
    }
}
