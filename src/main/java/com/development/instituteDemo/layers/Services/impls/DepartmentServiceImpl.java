package com.development.instituteDemo.layers.Services.impls;

import com.development.instituteDemo.layers.Services.DepartmentService;
import com.development.instituteDemo.layers.models.Department;
import com.development.instituteDemo.layers.repositories.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
//@SessionScope
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
