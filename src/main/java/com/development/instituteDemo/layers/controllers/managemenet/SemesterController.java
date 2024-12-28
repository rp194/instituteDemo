package com.development.instituteDemo.layers.controllers.managemenet;

import com.development.instituteDemo.layers.Mappers.SemesterMapper;
import com.development.instituteDemo.layers.Services.SemesterService;
import com.development.instituteDemo.layers.models.Semester;
import com.development.instituteDemo.layers.models.dto.SemesterDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operator/semester")
public class SemesterController {
    private SemesterService semesterService;
    private SemesterMapper semesterMapper;

    public SemesterController(SemesterService semesterService, SemesterMapper semesterMapper) {
        this.semesterService = semesterService;
        this.semesterMapper = semesterMapper;
    }

    @PostMapping
    public ResponseEntity<SemesterDto> createSemester(@RequestBody SemesterDto semesterDto) {
        Semester semester = semesterMapper.toEntity(semesterDto);
        Semester createdSemester = semesterService.saveSemester(semester);
        SemesterDto createdSemesterDto = semesterMapper.toDto(createdSemester);
        return new ResponseEntity<>(createdSemesterDto, HttpStatus.CREATED);
    }
}
