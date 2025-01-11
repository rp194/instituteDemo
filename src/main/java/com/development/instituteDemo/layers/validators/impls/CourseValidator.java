package com.development.instituteDemo.layers.validators.impls;

import com.development.instituteDemo.layers.models.*;
import com.development.instituteDemo.layers.repositories.repositories.*;
import com.development.instituteDemo.layers.validators.Validator;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseValidator implements Validator<Course> {
    private ProfessorRepository professorRepository;
    private DepartmentRepository departmentRepository;
    private LessonRepository lessonRepository;
    private SemesterRepository semesterRepository;

    public CourseValidator(ProfessorRepository professorRepository,
                           DepartmentRepository departmentRepository,
                           LessonRepository lessonRepository,
                           SemesterRepository semesterRepository) {
        this.professorRepository = professorRepository;
        this.departmentRepository = departmentRepository;
        this.lessonRepository = lessonRepository;
        this.semesterRepository = semesterRepository;

    }

    @Override
    public void validateFields(Course courseEntity) {
        validateParentProfessor(courseEntity.getProfessor());
        validateParentDepartment(courseEntity.getDepartment());
        validateParentLesson(courseEntity.getLesson());
        validateParentSemester(courseEntity.getSemester());
    }


    private void validateParentProfessor(Professor professor) {
        if (!professorRepository.existsById(professor.getId())) {
            throw new ValidationException("No such professor with id:" + professor.getId() + " exists yet!");
        }
    }

    private void validateParentDepartment(Department department) {
        if (!departmentRepository.existsById(department.getId())) {
            throw new ValidationException("No such department with id:" + department.getId() + " exists yet!");
        }
    }

    private void validateParentLesson(Lesson lesson) {
        if (!lessonRepository.existsById(lesson.getId())) {
            throw new ValidationException("No such lesson with id:" + lesson.getId() + " exists yet!");
        }
    }

    private void validateParentSemester(Semester semester) {
        if (!semesterRepository.existsById(semester.getId())) {
            throw new ValidationException("No such semester with id:" + semester.getId() + " exists yet!");
        }
    }

}
