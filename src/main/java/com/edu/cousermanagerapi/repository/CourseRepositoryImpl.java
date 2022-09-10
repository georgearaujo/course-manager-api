package com.edu.cousermanagerapi.repository;

import com.edu.cousermanagerapi.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private static List<Course> courses;

    public CourseRepositoryImpl() {
        courses = buildCourses();
    }
    @Override
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public Course findCourseById(Integer id) {
        return courses.stream().filter(course -> course.getId().equals(id)).findFirst().orElse(new Course());
    }

    @Override
    public Course createCourse(Course course) {
        var maxId = courses.stream().max(Comparator.comparing(Course::getId)).get().getId();
        course.setId(maxId + 1);
        courses.add(course);
        sortList();
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        var optionalCourse = courses.stream().filter(presentCourse -> presentCourse.getId() == course.getId() ).findFirst();
        if(optionalCourse.isPresent()) {
            courses.remove(optionalCourse.get());
            courses.add(course);
            sortList();
            return course;
        }
        return new Course();
    }

    @Override
    public Boolean deleteCourse(Integer id) {
        var optionalCourse = courses.stream().filter(presentCourse -> presentCourse.getId() == id ).findFirst();
        return optionalCourse.map(course -> courses.remove(course)).orElse(false);
    }

    private void sortList() {
        courses.sort(Comparator.comparing(Course::getId));
    }
    private List<Course> buildCourses() {
        var courses = new ArrayList<Course>();
        courses.add(new Course(
                1,
                "Angular: CLI",
                "November 2, 2019",
                "Neste curso, os alunos irão obter um grande conhecimento nos principais recursos do CLI.",
                120,
                "XLF-1212",
                3.0,
                12.99,
                "/assets/images/cli.png"
        ));
        courses.add(new Course(
                2,
                "Angular: Forms",
                "November 4, 2019",
                "Neste curso, os alunos irão obter um conhecimento aprofundado sobre os recursos disponíveis no módulo de Forms.",
                80,
                "DWQ-3412",
                3.5,
                24.99,
                "/assets/images/forms.png"
        ));
        courses.add(new Course(
            3,
            "Angular: HTTP",
            "November 8, 2019",
            "Neste curso, os alunos irão obter um conhecimento aprofundado sobre os recursos disponíveis no módulo de HTTP.",
            80,
            "QPL-0913",
            4.0,
            36.99,
            "/assets/images/http.png"
        ));
                courses.add(new Course(
            4,
            "Angular: Router",
            "November 16, 2019",
            "Neste curso, os alunos irão obter um conhecimento aprofundado sobre os recursos disponíveis no módulo de Router.",
            80,
            "OHP-1095",
            4.5,
            46.99,
            "/assets/images/router.png"
        ));
        courses.add(new Course(
            5,
            "Angular: Animations",
            "November 25, 2019",
            "Neste curso, os alunos irão obter um conhecimento aprofundado sobre os recursos disponíveis sobre Animation.",
            80,
            "PWY-9381",
            5.0,
            56.99,
            "/assets/images/animations.png"
        ));

        return courses;
    }
}
