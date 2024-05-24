package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Defines a Spring Data JPA repository interface for interacting with student data stored in a relational database
// @Repository annotation marks the interface as a Spring Data JPA repository to interact with data access layer functionalities
// Interface extends JpaRepository<Student, Long> which indicates that this repository manages Student entities and uses Long as the primary key type (likely student ID)
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // @Query defines a custom JPQL query named findStudentByEmail
    // ?1 represents the 1st query parameter (email in this case)
    // ?2 will represent the 2nd query parameter, and so on...
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
