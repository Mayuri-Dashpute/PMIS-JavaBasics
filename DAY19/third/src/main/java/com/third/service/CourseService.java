package com.third.service;

import com.third.entity.Course;
import com.third.repository.CourseRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    // Constructor Injection
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Create Course
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // Get All Courses
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    // Get Course By ID
    public Course getCourse(Long courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    // Update Course
    public Course updateCourse(Long courseId, Course courseDetails) {

        Course existingCourse = courseRepository.findById(courseId).orElse(null);

        if (existingCourse == null) {
            return null;
        }

        existingCourse.setTitle(courseDetails.getTitle());
        existingCourse.setDescription(courseDetails.getDescription());

        return courseRepository.save(existingCourse);
    }

    // Delete Course
    public boolean deleteCourse(Long courseId) {

        if (!courseRepository.existsById(courseId)) {
            return false;
        }

        courseRepository.deleteById(courseId);
        return true;
    }
}