
package com.StudentManagement.repository;

import com.StudentManagement.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * StudentRepository
 *
 * Responsible for storing and retrieving
 * student data using ArrayList.
 *
 * Initializes two students when the application starts.
 */

@Repository
public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    private Long nextId = 3L;

    public StudentRepository() {

        students.add(new Student(
                1L,
                "Rahul Sharma",
                "rahul@example.com",
                "Java"
        ));

        students.add(new Student(
                2L,
                "Priya Singh",
                "priya@example.com",
                "Spring Boot"
        ));
    }

    // Get all students
    public List<Student> findAll() {
        return students;
    }

    // Find student by ID
    public Optional<Student> findById(Long id) {

        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    // Add student
    public Student save(Student student) {

        student.setId(nextId++);

        students.add(student);

        return student;
    }

    // Update student
    public Optional<Student> update(Long id, Student updatedStudent) {

        Optional<Student> existingStudent = findById(id);

        if (existingStudent.isPresent()) {

            Student student = existingStudent.get();

            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setCourse(updatedStudent.getCourse());

            return Optional.of(student);
        }

        return Optional.empty();
    }

    // Delete student
    public boolean deleteById(Long id) {

        return students.removeIf(
                student -> student.getId().equals(id)
        );
    }
}
