package com.development.instituteDemo.layers.controllers.utilization.student;

import com.development.instituteDemo.layers.Mappers.RegisteredCourseMapper;
import com.development.instituteDemo.layers.Services.RegisteredCourseService;
import com.development.instituteDemo.layers.models.RegisteredCourse;
import com.development.instituteDemo.layers.models.dto.RegisteredCourseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentRegisteredCourseController {
    private RegisteredCourseService registeredCourseService;
    private RegisteredCourseMapper registeredCourseMapper;

    public StudentRegisteredCourseController(RegisteredCourseService registeredCourseService, RegisteredCourseMapper registeredCourseMapper) {
        this.registeredCourseService = registeredCourseService;
        this.registeredCourseMapper = registeredCourseMapper;
    }

    @PostMapping
    public ResponseEntity<RegisteredCourseDto> requestToCreateRegisteredCourse
            (@Valid @RequestBody RegisteredCourseDto registeredCourseDto) {
        RegisteredCourse registeredCourse = registeredCourseMapper.toEntity(registeredCourseDto);
        RegisteredCourse resultedRegisteredCourse = registeredCourseService.requestRegisteredCourse(registeredCourse);
        RegisteredCourseDto resultedRegisteredCourseDto = registeredCourseMapper.toDto(resultedRegisteredCourse);
        return new ResponseEntity<>(resultedRegisteredCourseDto, HttpStatus.CREATED);
    }
    @GetMapping(path = "/{id}/gpa")
    public ResponseEntity<String> getGpa(@PathVariable("id") Long studentId) {
        if (registeredCourseService.isTableEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Double gpa = registeredCourseService.findGpa(studentId);
        return new ResponseEntity<>("The gpa of the student is " + gpa, HttpStatus.FOUND);
    }
}