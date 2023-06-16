package com.ntt.demo.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeviceRequest {

    protected String description;

    @NotEmpty(message = "Debe indicar el nombre del dispositivo")
    protected String name;

    @NotNull(message = "Debe indicar el valor del dispositivo")
    protected Double purchaseAmount;
}
