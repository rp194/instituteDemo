package com.development.instituteDemo.layers.validators.impls;

import com.development.instituteDemo.layers.models.Course;
import com.development.instituteDemo.layers.models.RegisteredCourse;
import com.development.instituteDemo.layers.models.Student;
import com.development.instituteDemo.layers.repositories.repositories.CourseRepository;
import com.development.instituteDemo.layers.repositories.repositories.RegisteredCourseRepository;
import com.development.instituteDemo.layers.repositories.repositories.StudentRepository;
import com.development.instituteDemo.layers.validators.Validator;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisteredCourseValidator implements Validator<RegisteredCourse> {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private RegisteredCourseRepository registeredCourseRepository;

    public RegisteredCourseValidator(StudentRepository studentRepository,
                                     CourseRepository courseRepository,
                                     RegisteredCourseRepository registeredCourseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.registeredCourseRepository = registeredCourseRepository;
    }

    @Override
    public void validateFields(RegisteredCourse registeredCourseEntity) {
        validateParentStudent(registeredCourseEntity.getStudent());
        validateParentCourse(registeredCourseEntity.getCourse());
    }

    @Override
    public void additionalAccess(String accessType, Long validationKey, Long validationReference) {
        switch (accessType) {
            case "setGrade" : {
                if (!courseRepository.isAssociated(validationKey, validationReference)) {
                    throw new IllegalArgumentException("This professor with id:" + validationKey +
                            " is not associated with this course id:" + validationReference);
                }
            }
            case "registerRequest" : {
                Course course = courseRepository.findById(validationReference).get();
                validateCapacity(course.getCapacity());
                List<Course> currentCourses = registeredCourseRepository.findCoursesByStudentId(validationKey);
                Course timeConflictedCourse = anyConflict(currentCourses, course);
                if (timeConflictedCourse != null) {
                    throw new RuntimeException("Timing conflict with course id: " + timeConflictedCourse.getId());
                }
            }
            default: throw new RuntimeException("No such access type is defined");

        }
    }

    private void validateParentStudent(Student student) {
        if (!studentRepository.existsById(student.getId())) {
            throw new ValidationException("No such student with id:" + student.getId() + " exists yet!");
        }
    }

    private void validateParentCourse(Course course) {
        if (!courseRepository.existsById(course.getId())) {
            throw new ValidationException("No such course with id:" + course.getId() + " exists yet!");
        }
    }

    private void validateCapacity(Integer capacity) {
        if (capacity != null && capacity == 0) {
            throw new RuntimeException("The course is not available to be registered due to capacity!");
        }
    }

    private Course anyConflict(List<Course> currentCourses, Course course) {
        for (Course currentCourse : currentCourses) {
            boolean dayConflict = currentCourse.getDay_1().equals(course.getDay_1()) ||
                    currentCourse.getDay_1().equals(course.getDay_2()) ||
                    currentCourse.getDay_2().equals(course.getDay_1()) ||
                    currentCourse.getDay_2().equals(course.getDay_2());
            boolean hourConflict = (course.getStartHour() < currentCourse.getEndHour() &&
                    currentCourse.getStartHour() < course.getEndHour());
            if (dayConflict && hourConflict) {
                return currentCourse;
            }
        }
        return null;
    }
}
