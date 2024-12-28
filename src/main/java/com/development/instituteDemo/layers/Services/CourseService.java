package com.development.instituteDemo.layers.Services;

import com.development.instituteDemo.layers.models.Course;
import org.springframework.stereotype.Service;


public interface CourseService {

    Course saveCourse(Course course);
}
