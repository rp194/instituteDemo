package com.development.instituteDemo.layers.Services.impls;

import com.development.instituteDemo.layers.Services.DepartmentService;
import com.development.instituteDemo.layers.models.Department;
import com.development.instituteDemo.layers.repositories.repositories.DepartmentRepository;
import com.development.instituteDemo.layers.validators.Validator;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
//@SessionScope
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private Validator<Department> departmentValidator;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, Validator<Department> departmentValidator) {
        this.departmentRepository = departmentRepository;
        this.departmentValidator = departmentValidator;
    }

    @Override
    public Department saveDepartment(Department department) {
        departmentValidator.validateFields(department);
        return departmentRepository.save(department);
    }
}
