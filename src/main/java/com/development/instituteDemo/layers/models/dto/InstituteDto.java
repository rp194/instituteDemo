package com.development.instituteDemo.layers.models.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class InstituteDto {
    private Long id;
    private String name;
    private String location;
}
