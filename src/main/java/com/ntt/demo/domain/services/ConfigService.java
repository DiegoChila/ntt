package com.ntt.demo.domain.services;

import com.ntt.demo.domain.dto.ConfigDto;
import com.ntt.demo.domain.dto.ConfigRequest;

import java.util.List;

public interface ConfigService {

    List<ConfigDto> getAllConfigs();
    ConfigDto saveConfig(ConfigRequest configRequest);
    ConfigDto getActualConfig();
}
