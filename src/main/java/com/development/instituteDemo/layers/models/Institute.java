package com.development.instituteDemo.layers.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "institutes")
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "institute_id_seq")
    private Long id;
    private String name;
    private String location;
}
