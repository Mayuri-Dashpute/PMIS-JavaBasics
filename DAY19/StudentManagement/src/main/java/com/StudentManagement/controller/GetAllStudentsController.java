
package com.StudentManagement.controller;

import com.StudentManagement.entity.Student;
import com.StudentManagement.service.StudentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Handles GET request to retrieve
 * all students from the application.
 */

@RestController
@RequestMapping("/students")
public class GetAllStudentsController {

    private final StudentService studentService;

    public GetAllStudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }
}
