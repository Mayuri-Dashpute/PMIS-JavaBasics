
package com.StudentManagement.service;

import com.StudentManagement.entity.Student;
import com.StudentManagement.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 * StudentService
 *
 * Contains application logic.
 * Communicates with StudentRepository
 * to perform CRUD operations.
 */

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Get all students
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    // Get student by ID
    public Optional<Student> getStudentById(Long id) {

        return studentRepository.findById(id);
    }

    // Add new student
    public Student addStudent(Student student) {

        return studentRepository.save(student);
    }

    // Update student
    public Optional<Student> updateStudent(Long id, Student student) {

        return studentRepository.update(id, student);
    }

    // Delete student
    public boolean deleteStudent(Long id) {

        return studentRepository.deleteById(id);
    }
}
