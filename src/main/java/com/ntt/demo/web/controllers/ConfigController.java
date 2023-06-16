package com.ntt.demo.web.controllers;

import com.ntt.demo.domain.dto.ConfigDto;
import com.ntt.demo.domain.dto.ConfigRequest;
import com.ntt.demo.domain.services.ConfigService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/config")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @PostMapping
    public ResponseEntity<ConfigDto> saveConfig(@RequestBody @Valid ConfigRequest configRequest) {
        return new ResponseEntity<>(configService.saveConfig(configRequest), HttpStatus.CREATED);
    }
}
