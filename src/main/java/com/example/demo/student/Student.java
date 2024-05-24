package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

// @Entity annotation marks class as a JPA entity, entities are mapped to database tables.
// @Table annotation specifies name of database table associated with this entity. By default, table name will be class name, which is "student"
// This class serves as a model for representing student data in application
@Entity
@Table
public class Student {
    // @Id annotation marks id property as primary key for entity
    @Id

    // @SequenceGenerator annotation defines a sequence generator for primary key
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    // @GeneratedValue annotation specifies how the value for id filed will be generated
    @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    // The above annotations configure database to automatically generate unique IDs for each student record

    private Long id;
    private String name;
    private String email;
    private LocalDate dob;

    // @Transient annotation marks age property as transient, where it is not persisted to the database
    @Transient
    private Integer age;

    public Student() {

    }
    public Student(Long id,
                   String name,
                   String email,
                   LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name,
                   String email,
                   LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
