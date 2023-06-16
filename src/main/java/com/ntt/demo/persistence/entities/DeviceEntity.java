package com.ntt.demo.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "devices")
@Getter
@Setter
public class DeviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serial;

    private String description;

    private String name;

    private LocalDateTime purchaseDate;

    private Double purchaseAmount;

    private LocalDateTime lastValueUpdate;

    private Double actualValue;
}
