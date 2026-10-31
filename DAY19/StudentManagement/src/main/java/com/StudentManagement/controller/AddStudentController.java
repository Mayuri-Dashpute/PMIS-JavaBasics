
package com.StudentManagement.controller;

import com.StudentManagement.entity.Student;
import com.StudentManagement.service.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * Handles POST request.
 * Accepts student JSON using @RequestBody.
 * Returns 201 Created after successful insertion.
 */

@RestController
@RequestMapping("/students")
public class AddStudentController {

    private final StudentService studentService;

    public AddStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(
            @RequestBody Student student) {

        Student savedStudent =
                studentService.addStudent(student);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedStudent);
    }
}
