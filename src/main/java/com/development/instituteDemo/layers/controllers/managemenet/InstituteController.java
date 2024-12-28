package com.development.instituteDemo.layers.controllers.managemenet;

import com.development.instituteDemo.layers.Mappers.InstituteMapper;
import com.development.instituteDemo.layers.Services.InstituteService;
import com.development.instituteDemo.layers.models.Institute;
import com.development.instituteDemo.layers.models.dto.InstituteDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operator/institute")
public class InstituteController {
    private InstituteService instituteService;
    private InstituteMapper instituteMapper;

    public InstituteController(InstituteService instituteService, InstituteMapper instituteMapper) {
        this.instituteService = instituteService;
        this.instituteMapper = instituteMapper;
    }

    @PostMapping
    public ResponseEntity<InstituteDto> createInstitute(@RequestBody InstituteDto instituteDto) {
        Institute institute = instituteMapper.toEntity(instituteDto);
        Institute createdInstitute = instituteService.saveInstitute(institute);
        InstituteDto createdInstituteDto = instituteMapper.toDto(createdInstitute);
        return new ResponseEntity<>(createdInstituteDto, HttpStatus.CREATED);
    }
}
