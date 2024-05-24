package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController marks the class as a REST controller, meaning it handles HTTP requests for student-related functionalities
// @RequestMapping(...) defines the base path for all request mappings within this controller. Any request URL starting with
// "api/v1/student" will be handled by the methods in this class
// This controller acts an intermediary between user requests and actual student data management handled by StudentService
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    // @Autowired annotation tells Spring to automatically inject an instance of StudentService into this field during object creation
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Method is called when a GET request is sent to the root path ("/").
    // Retrieves all students using studentService.getStudents() and returns  a list of Student objects
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    // Method handles POST requests for creating new students, by expecting a Student object passed into the request body using @RequestBody
    // Calls studentService.addNewStudents(student) to add new student data
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    // Method handles DELETE requests to delete a student, by taking student ID as a path variable
    // Calls studentService.deleteStudent(studentId) to remove student with that ID
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable ("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    // Method handles PUT requests to update student information by taking student ID as a path variable and uses optional
    // request parameters to get updated name and email
    // Calls studentService.updateStudent(...) to update student's details
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        studentService.updateStudent(studentId, name, email);
    }
}
