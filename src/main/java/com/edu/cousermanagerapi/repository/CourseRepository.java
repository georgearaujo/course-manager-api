package com.edu.cousermanagerapi.repository;

import com.edu.cousermanagerapi.entity.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> getCourses();
    Course findCourseById(Integer id);
    Course createCourse(Course course);
    Course updateCourse(Course course);
    Boolean deleteCourse(Integer id);
}
