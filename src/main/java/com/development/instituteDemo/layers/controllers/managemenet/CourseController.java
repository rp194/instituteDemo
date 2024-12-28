package com.development.instituteDemo.layers.controllers.managemenet;

import com.development.instituteDemo.layers.Mappers.CourseMapper;
import com.development.instituteDemo.layers.Services.CourseService;
import com.development.instituteDemo.layers.models.Course;
import com.development.instituteDemo.layers.models.dto.CourseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operator/course")
public class CourseController {
    private CourseService courseService;
//    private Mapper<Course, CourseDto> courseMapper;
    private CourseMapper courseMapper;

    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody CourseDto courseDto) {
        Course course = courseMapper.toEntity(courseDto);
        Course createdCourse = courseService.saveCourse(course);
        CourseDto createdCourseDto = courseMapper.toDto(createdCourse);
        return new ResponseEntity<>(createdCourseDto, HttpStatus.CREATED);
    }
}
