package com.development.instituteDemo.layers.repositories.repositories;

import com.development.instituteDemo.layers.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, String> {

}
