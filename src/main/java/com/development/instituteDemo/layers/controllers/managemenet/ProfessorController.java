package com.development.instituteDemo.layers.controllers.managemenet;

import com.development.instituteDemo.layers.Mappers.ProfessorMapper;
import com.development.instituteDemo.layers.Services.ProfessorService;
import com.development.instituteDemo.layers.models.Professor;
import com.development.instituteDemo.layers.models.dto.ProfessorDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operator/professor")
public class ProfessorController {
    private ProfessorService professorService;

    private ProfessorMapper professorMapper;

    public ProfessorController(ProfessorService professorService, ProfessorMapper professorMapper) {
        this.professorService = professorService;
        this.professorMapper = professorMapper;
    }

    @PostMapping
    public ResponseEntity<ProfessorDto> createProfessor(@Valid @RequestBody ProfessorDto professorDto) {
        Professor professor = professorMapper.toEntity(professorDto);
        Professor createdProfessor = professorService.saveProfessor(professor);
        ProfessorDto createdProfessorDto = professorMapper.toDto(createdProfessor);
        return new ResponseEntity<>(createdProfessorDto, HttpStatus.CREATED);
    }
}
