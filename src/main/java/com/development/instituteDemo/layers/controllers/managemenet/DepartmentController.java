package com.development.instituteDemo.layers.controllers.managemenet;

import com.development.instituteDemo.layers.Mappers.DepartmentMapper;
import com.development.instituteDemo.layers.Services.DepartmentService;
import com.development.instituteDemo.layers.models.Department;
import com.development.instituteDemo.layers.models.dto.DepartmentDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operator/department")
public class DepartmentController {
    private DepartmentService departmentService;
    private DepartmentMapper departmentMapper;


    public DepartmentController(DepartmentService departmentService, DepartmentMapper departmentMapper) {
        this.departmentService = departmentService;
        this.departmentMapper = departmentMapper;
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        Department department = departmentMapper.toEntity(departmentDto);
        Department createdDepartment = departmentService.saveDepartment(department);
        DepartmentDto createdDepartmentDto = departmentMapper.toDto(createdDepartment);
        return new ResponseEntity<>(createdDepartmentDto, HttpStatus.CREATED);
    }
}
