
package com.StudentManagement.controller;

import com.StudentManagement.entity.Student;
import com.StudentManagement.service.StudentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/*
 * Handles PUT request.
 * Updates existing student details.
 * Returns 404 when student ID does not exist.
 */

@RestController
@RequestMapping("/students")
public class UpdateStudentController {

    private final StudentService studentService;

    public UpdateStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long studentId,
            @RequestBody Student student) {

        Optional<Student> updatedStudent =
                studentService.updateStudent(studentId, student);

        return updatedStudent
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
