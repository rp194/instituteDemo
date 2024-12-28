package com.development.instituteDemo.layers.Mappers;

import com.development.instituteDemo.layers.models.Course;
import com.development.instituteDemo.layers.models.Student;
import com.development.instituteDemo.layers.models.RegisteredCourse;
import com.development.instituteDemo.layers.models.dto.RegisteredCourseDto;
import com.development.instituteDemo.layers.repositories.repositories.CourseRepository;
import com.development.instituteDemo.layers.repositories.repositories.StudentRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegisteredCourseMapper {
    @Mapping(target = "student.id", source = "studentId")
    @Mapping(target = "course.id", source = "courseId")
    RegisteredCourse toEntity(RegisteredCourseDto registeredCourseDto);

    @Mapping(target = "studentId", source = "student")
    @Mapping(target = "courseId", source = "course")
    RegisteredCourseDto toDto(RegisteredCourse registeredCourse);

    default Long mapStudentId(Student student) {
        return (student != null) ? student.getId() : null;
    }

    default Student mapStudent(Long id, @Context StudentRepository studentRepository) {
        return (id != null) ? studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with ID " + id + " not found")) : null;
    }

    default Long mapStudentId(Course course) {
        return (course != null) ? course.getId() : null;
    }

    default Course mapCourse(Long id, @Context CourseRepository courseRepository) {
        return (id != null) ? courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course with ID " + id + " not found")) : null;
    }


}
