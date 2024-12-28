package com.development.instituteDemo.layers.models.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SemesterDto {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
}
