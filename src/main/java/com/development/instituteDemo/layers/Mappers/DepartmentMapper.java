package com.development.instituteDemo.layers.Mappers;

import com.development.instituteDemo.layers.models.Department;
import com.development.instituteDemo.layers.models.Institute;
import com.development.instituteDemo.layers.models.dto.DepartmentDto;
import com.development.instituteDemo.layers.repositories.repositories.InstituteRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(target = "institute.id", source = "instituteId")
    Department toEntity(DepartmentDto departmentDto);

    @Mapping(target = "instituteId", source = "institute")
    DepartmentDto toDto(Department department);

    default Long map(Institute institute) {
        return (institute != null) ? institute.getId() : null;
    }

    default Institute map(Long id, @Context InstituteRepository instituteRepository) {
        return (id != null) ? instituteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Institute with ID " + id + " not found")) : null;
    }
}

//    DepartmentMapStruct INSTANCE = Mappers.getMapper(DepartmentMapStruct.class);
//
//    @Mapping(target = "instituteId", source = "institute.id") // Map institute.id in entity to instituteId in DTO
//    DepartmentDto departmentToDepartmentDto(Department department);
//
//    @Mapping(target = "institute.id", source = "instituteId") // Map instituteId in DTO to institute.id in entity
//    Department departmentDtoToDepartment(DepartmentDto departmentDto);
//
//    @Mapping(target = "institute", ignore = true)
//    @Mapping(target = "institute.id", source = "instituteId") // Map instituteId in DTO to institute.id in entity
//    Department departmentDtoToDepartment(DepartmentDto departmentDto, @MappingTarget Department department);
//
//    InstituteDto instituteToInstituteDto(Institute institute);
//
//    @Mapping(target = "id", ignore = true)
//    Institute instituteDtoToInstitute(InstituteDto instituteDto);

//}

