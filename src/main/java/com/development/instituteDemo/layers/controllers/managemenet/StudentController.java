package com.development.instituteDemo.layers.controllers.managemenet;

import com.development.instituteDemo.layers.Mappers.StudentMapper;
import com.development.instituteDemo.layers.Services.StudentService;
import com.development.instituteDemo.layers.models.Student;
import com.development.instituteDemo.layers.models.dto.StudentDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operator/student")
public class StudentController {
    private StudentService studentService;
    private StudentMapper studentMapper;

    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentDto studentDto) {
        Student student = studentMapper.toEntity(studentDto);
        Student createdStudent = studentService.saveStudent(student);
        StudentDto createdStudentDto = studentMapper.toDto(createdStudent);
        return new ResponseEntity<>(createdStudentDto, HttpStatus.CREATED);
    }
}
