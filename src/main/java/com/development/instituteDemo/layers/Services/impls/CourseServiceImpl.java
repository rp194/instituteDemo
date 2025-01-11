package com.development.instituteDemo.layers.Services.impls;

import com.development.instituteDemo.layers.Services.CourseService;
import com.development.instituteDemo.layers.models.Course;
import com.development.instituteDemo.layers.repositories.repositories.CourseRepository;
import com.development.instituteDemo.layers.validators.Validator;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;
    private Validator<Course> courseValidator;

    public CourseServiceImpl(CourseRepository courseRepository, Validator<Course> courseValidator) {
        this.courseRepository = courseRepository;
        this.courseValidator = courseValidator;
    }

    @Override
    public Course saveCourse(Course course) {
        courseValidator.validateFields(course);
        return courseRepository.save(course);
    }
}
