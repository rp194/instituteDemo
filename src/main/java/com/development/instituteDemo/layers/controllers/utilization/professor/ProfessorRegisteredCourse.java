package com.development.instituteDemo.layers.controllers.utilization.professor;

import com.development.instituteDemo.layers.Mappers.RegisteredCourseMapper;
import com.development.instituteDemo.layers.Services.RegisteredCourseService;
import com.development.instituteDemo.layers.models.RegisteredCourse;
import com.development.instituteDemo.layers.models.dto.RegisteredCourseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorRegisteredCourse {
    private RegisteredCourseService registeredCourseService;
    private RegisteredCourseMapper registeredCourseMapper;

    public ProfessorRegisteredCourse(RegisteredCourseService registeredCourseService, RegisteredCourseMapper registeredCourseMapper) {
        this.registeredCourseService = registeredCourseService;
        this.registeredCourseMapper = registeredCourseMapper;
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<RegisteredCourseDto> setGradeRegisteredCourse
            (@PathVariable("id") Long id, @Valid @RequestBody RegisteredCourseDto registeredCourseDto) {
        Long professorId = id;
        RegisteredCourse registeredCourse = registeredCourseMapper.toEntity(registeredCourseDto);
        RegisteredCourse resultedRegisteredCourse = registeredCourseService.SetGrade(professorId, registeredCourse);
        RegisteredCourseDto resultedRegisteredCourseDto = registeredCourseMapper.toDto(resultedRegisteredCourse);
        return new ResponseEntity<>(resultedRegisteredCourseDto, HttpStatus.ACCEPTED);
    }
}
