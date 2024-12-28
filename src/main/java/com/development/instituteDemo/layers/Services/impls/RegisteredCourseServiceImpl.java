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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisteredCourseServiceImpl implements RegisteredCourseService {
    private RegisteredCourseRepository registeredCourseRepository;
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private ProfessorRepository professorRepository;

    public RegisteredCourseServiceImpl(RegisteredCourseRepository registeredCourseRepository,
                                       StudentRepository studentRepository,
                                       CourseRepository courseRepository,
                                       ProfessorRepository professorRepository) {
        this.registeredCourseRepository = registeredCourseRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    public RegisteredCourse requestRegisteredCourse(RegisteredCourse registeredCourse) {
        Long stdNo = registeredCourse.getStudent().getId();
        Long courseId = registeredCourse.getCourse().getId();
        Student student = studentRepository.findById(stdNo)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        if (course.getCapacity() == null || course.getCapacity() <= 0) {
            throw new RuntimeException("Course is full or not initialised");
        }
        List<Course> currentCourses = registeredCourseRepository.findCoursesByStudentId(stdNo);
        Course timeConflictedCourse = anyConflict(currentCourses, course);
        if (timeConflictedCourse != null) {
            throw new RuntimeException("Timing conflict with course ID: " + timeConflictedCourse.getId());
        }
        registeredCourse.setGrade(null);
        return  registeredCourseRepository.save(registeredCourse);
    }

    @Override
    public RegisteredCourse SetGrade(Long professorId, RegisteredCourse registeredCourse) {
        Long stdNo = registeredCourse.getStudent().getId();
        Long courseId = registeredCourse.getCourse().getId();
        Double grade = registeredCourse.getGrade();
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor not found"));
        RegisteredCourse foundRegisteredCourse = registeredCourseRepository.findStudentsByProfNo(professorId, courseId, stdNo);
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
