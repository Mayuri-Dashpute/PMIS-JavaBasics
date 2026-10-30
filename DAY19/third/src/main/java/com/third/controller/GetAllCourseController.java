
package com.third.controller;

import com.third.entity.Course;
import com.third.service.CourseService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class GetAllCourseController {

    private final CourseService courseService;

    public GetAllCourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }
}
