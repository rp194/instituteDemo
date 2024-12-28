package com.development.instituteDemo.layers.repositories.repositories;

import com.development.instituteDemo.layers.models.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
}
