package com.development.instituteDemo.layers.validators.impls;

import com.development.instituteDemo.layers.models.Department;
import com.development.instituteDemo.layers.models.Institute;
import com.development.instituteDemo.layers.repositories.repositories.InstituteRepository;
import com.development.instituteDemo.layers.validators.Validator;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class DepartmentValidator implements Validator<Department> {
    private InstituteRepository instituteRepository;

    public DepartmentValidator(InstituteRepository instituteRepository) {
        this.instituteRepository = instituteRepository;
    }

    @Override
    public void validateFields(Department departmentEntity) {
        validateParentInstitute(departmentEntity.getInstitute());
    }

    private void validateParentInstitute(Institute institute) {
        if (!instituteRepository.existsById(institute.getId())) {
            throw new ValidationException("No such institute with id:" + institute.getId() + " exists yet!");
        }
    }
}
