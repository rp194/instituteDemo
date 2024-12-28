package com.development.instituteDemo.layers.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "persons")
public class Person {
    @Id
    private String nationalId;
    private String firstName;
    private String lastName;
    private String role;
    private String email;
}
