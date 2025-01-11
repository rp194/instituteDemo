package com.development.instituteDemo.layers.Services.impls;

import com.development.instituteDemo.layers.Services.RegisteredCourseService;
import com.development.instituteDemo.layers.models.Course;
import com.development.instituteDemo.layers.models.Professor;
import com.development.instituteDemo.layers.models.RegisteredCourse;
import com.development.instituteDemo.layers.models.Student;
import com.development.instituteDemo.layers.repositories.repositories.CourseRepository;
import com.development.instituteDemo.layers.repositories.repositories.ProfessorRepository;
import com.development.instituteDemo.layers.repositories.repositories.RegisteredCourseRepository;
import com.development.instituteDemo.layers.repositories.repositories.StudentRepository;
import com.development.instituteDemo.layers.validators.Validator;
import com.development.instituteDemo.layers.validators.impls.CourseValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisteredCourseServiceImpl implements RegisteredCourseService {
    private RegisteredCourseRepository registeredCourseRepository;
    private CourseRepository courseRepository;
    private ProfessorRepository professorRepository;
    private Validator<RegisteredCourse> registeredCourseValidator;
    private Validator<Course> courseValidator;
    private Validator<Professor> professorValidator;


    public RegisteredCourseServiceImpl(RegisteredCourseRepository registeredCourseRepository,
                                       CourseRepository courseRepository,
                                       ProfessorRepository professorRepository,
                                       Validator<RegisteredCourse> registeredCourseValidator,
                                       Validator<Course> courseValidator,
                                       Validator<Professor> professorValidator) {
        this.registeredCourseRepository = registeredCourseRepository;
        this.courseRepository = courseRepository;
        this.professorRepository = professorRepository;
        this.registeredCourseValidator = registeredCourseValidator;
        this.courseValidator = courseValidator;
        this.professorValidator = professorValidator;
    }

    @Override
    public RegisteredCourse requestRegisteredCourse(RegisteredCourse registeredCourse) {
        registeredCourseValidator.validateFields(registeredCourse);
        Long stdNo = registeredCourse.getStudent().getId();
        Long courseId = registeredCourse.getCourse().getId();
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        Course course = optionalCourse.orElse(null);
        registeredCourseValidator.additionalAccess("registerRequest", stdNo, courseId);
        assert course != null;
        course.setCapacity(course.getCapacity()-1);
        courseRepository.save(course);
        registeredCourse.setGrade(null);
        return  registeredCourseRepository.save(registeredCourse);
    }

    @Override
    public RegisteredCourse SetGrade(Long professorId, RegisteredCourse registeredCourse) {
        registeredCourseValidator.validateFields(registeredCourse);
        Long courseId = registeredCourse.getCourse().getId();
        registeredCourseValidator.additionalAccess("setGrade", professorId, courseId);
        Long stdNo = registeredCourse.getStudent().getId();
        Double grade = registeredCourse.getGrade();
        RegisteredCourse foundRegisteredCourse = registeredCourseRepository.findRegisteredCourse(courseId, stdNo);
        foundRegisteredCourse.setGrade(grade);
        return  registeredCourseRepository.save(foundRegisteredCourse);
    }

    @Override
    public boolean isTableEmpty() {
        return registeredCourseRepository.count() == 0;
    }

    @Override
    public Double findGpa(Long studentId) {
        return registeredCourseRepository.findGpa(studentId);

    }

}
