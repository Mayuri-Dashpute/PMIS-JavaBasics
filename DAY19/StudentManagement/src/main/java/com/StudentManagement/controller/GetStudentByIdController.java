
package com.StudentManagement.controller;

import com.StudentManagement.entity.Student;
import com.StudentManagement.service.StudentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/*
 * Handles GET request using student ID.
 * Returns 404 when student is not found.
 */

@RestController
@RequestMapping("/students")
public class GetStudentByIdController {

    private final StudentService studentService;

    public GetStudentByIdController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(
            @PathVariable Long studentId) {

        Optional<Student> student =
                studentService.getStudentById(studentId);

        return student
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
