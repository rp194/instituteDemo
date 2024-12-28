package com.development.instituteDemo.layers.Mappers;

import com.development.instituteDemo.layers.models.*;
import com.development.instituteDemo.layers.models.dto.CourseDto;
import com.development.instituteDemo.layers.repositories.repositories.DepartmentRepository;
import com.development.instituteDemo.layers.repositories.repositories.LessonRepository;
import com.development.instituteDemo.layers.repositories.repositories.ProfessorRepository;
import com.development.instituteDemo.layers.repositories.repositories.SemesterRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "department.id", source = "departmentId")
    @Mapping(target = "lesson.id", source = "lessonId")
    @Mapping(target = "semester.id", source = "semesterId")
    @Mapping(target = "professor.id", source = "professorId")
    Course toEntity(CourseDto courseDto);

    @Mapping(target = "departmentId", source = "department")
    @Mapping(target = "lessonId", source = "lesson")
    @Mapping(target = "semesterId", source = "semester")
    @Mapping(target = "professorId", source = "professor")
    CourseDto toDto(Course course);

    default Long map(Department department) {
        return (department != null) ? department.getId() : null;
    }
    default Long map(Lesson lesson) {
        return (lesson != null) ? lesson.getId() : null;
    }
    default Long map(Semester semester) {
        return (semester != null) ? semester.getId() : null;
    }
    default Long map(Professor professor) {
        return (professor != null) ? professor.getId() : null;
    }

    default Department map(Long id, @Context DepartmentRepository departmentRepository) {
        return (id != null) ? departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Department with ID " + id + " not found")) : null;
    }
    default Lesson map(Long id, @Context LessonRepository lessonRepository) {
        return (id != null) ? lessonRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lesson with ID " + id + " not found")) : null;
    }
    default Semester map(Long id, @Context SemesterRepository semesterRepository) {
        return (id != null) ? semesterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Semester with ID " + id + " not found")) : null;
    }
    default Professor map(Long id, @Context ProfessorRepository professorRepository) {
        return (id != null) ? professorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Professor with ID " + id + " not found")) : null;
    }

}
