package com.development.instituteDemo.layers.Services;

import com.development.instituteDemo.layers.models.RegisteredCourse;

public interface RegisteredCourseService {
    RegisteredCourse requestRegisteredCourse(RegisteredCourse registeredCourse);

    RegisteredCourse SetGrade(Long professorId, RegisteredCourse registeredCourse);

    boolean isTableEmpty();

    Double findGpa(Long studentId);
}
