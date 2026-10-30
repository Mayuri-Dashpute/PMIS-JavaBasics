
package com.third.controller;

import com.third.entity.Course;
import com.third.service.CourseService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class UpdateCourseController {

    private final CourseService courseService;

    public UpdateCourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(
            @PathVariable Long courseId,
            @RequestBody Course courseDetails
    ) {

        Course updatedCourse = courseService.updateCourse(courseId, courseDetails);

        if (updatedCourse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(updatedCourse);
    }
}
