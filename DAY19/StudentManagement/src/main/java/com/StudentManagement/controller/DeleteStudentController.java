
package com.StudentManagement.controller;

import com.StudentManagement.service.StudentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * Handles DELETE request.
 * Deletes a student using student ID.
 * Returns 204 if deletion succeeds.
 * Returns 404 if student does not exist.
 */

@RestController
@RequestMapping("/students")
public class DeleteStudentController {

    private final StudentService studentService;

    public DeleteStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable Long studentId) {

        boolean deleted =
                studentService.deleteStudent(studentId);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
