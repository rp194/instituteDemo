package com.development.instituteDemo.layers.repositories.repositories;

import com.development.instituteDemo.layers.models.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteRepository extends JpaRepository<Institute, Long> {
}
