package com.ntt.demo.domain.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ConfigDto {

    private Integer id;

    private Double depreciation;

    private Integer depreciationHours;
}
