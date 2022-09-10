package com.edu.cousermanagerapi.service;

import com.edu.cousermanagerapi.entity.Course;
import com.edu.cousermanagerapi.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getListCourse() {
        return courseRepository.getCourses();
    }

    public Course getCourse(Integer id) {
        return courseRepository.findCourseById(id);
    }

    public Course createCourse(Course course) {
        return courseRepository.createCourse(course);
    }

    public Course updateCourse(Course course) {
        return courseRepository.updateCourse(course);
    }

    public Boolean deleteCourse(Integer id) {
        return courseRepository.deleteCourse(id);
    }
}
