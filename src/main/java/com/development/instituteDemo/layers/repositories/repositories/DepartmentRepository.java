package com.development.instituteDemo.layers.repositories.repositories;

import com.development.instituteDemo.layers.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
