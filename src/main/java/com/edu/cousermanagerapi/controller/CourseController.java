package com.edu.cousermanagerapi.controller;

import com.edu.cousermanagerapi.entity.Course;
import com.edu.cousermanagerapi.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {
        log.info("Get all");
        var objectReturn = courseService.getListCourse();
        log.info("Return: {}", objectReturn);
        return ResponseEntity.ok(objectReturn);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable("id") Integer id) {
        log.info("Get id: {}", id);
        var objectReturn = courseService.getCourse(id);
        log.info("Return: {}", objectReturn);
        return ResponseEntity.ok(objectReturn);
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        log.info("Create: {}", course);
        var objectReturn = courseService.createCourse(course);
        log.info("Return: {}", objectReturn);
        return ResponseEntity.ok(courseService.createCourse(course));
    }

    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        log.info("Update: {}", course);
        var objectReturn = courseService.updateCourse(course);
        log.info("Return: {}", objectReturn);
        return ResponseEntity.ok(objectReturn);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCourse(@PathVariable("id") Integer id) {
        log.info("Delete id: {}", id);
        var objectReturn =courseService.deleteCourse(id);
        log.info("Return: {}", objectReturn);
        return ResponseEntity.ok(objectReturn);
    }
}
