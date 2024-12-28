package com.development.instituteDemo.layers.repositories.repositories;

import com.development.instituteDemo.layers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
