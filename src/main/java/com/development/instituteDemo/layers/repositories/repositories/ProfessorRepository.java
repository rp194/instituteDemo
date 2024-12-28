package com.development.instituteDemo.layers.repositories.repositories;

import com.development.instituteDemo.layers.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
