package com.ntt.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDto {

    private Long serial;

    private String description;

    private String name;

    private LocalDateTime purchaseDate;

    private Double purchaseAmount;

    private LocalDateTime lastValueUpdate;

    private Double actualValue;
}
