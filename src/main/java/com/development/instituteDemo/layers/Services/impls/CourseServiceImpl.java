package com.development.instituteDemo.layers.Services.impls;

import com.development.instituteDemo.layers.Services.CourseService;
import com.development.instituteDemo.layers.models.Course;
import com.development.instituteDemo.layers.repositories.repositories.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
}
