package com.ntt.demo.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConfigRequest {

    @NotNull(message = "Debe indicar el porcentaje de depreciación")
    private Double depreciation;

    @NotNull(message = "Debe indicar el número de horas para la depreciación")
    private Integer depreciationHours;
}
