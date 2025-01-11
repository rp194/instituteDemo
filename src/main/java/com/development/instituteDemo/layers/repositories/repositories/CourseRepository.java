package com.development.instituteDemo.layers.repositories.repositories;

import com.development.instituteDemo.layers.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("select case when count(c) > 0 then true else false end " +
            "from Course c where c.professor = :validationKey and c.id = :validationReference")
    boolean isAssociated(@Param("validationKey") Long validationKey, @Param("validationReference")  Long validationReference);

}
