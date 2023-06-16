package com.ntt.demo.domain.services.impl;

import com.ntt.demo.domain.dto.ConfigDto;
import com.ntt.demo.domain.dto.ConfigRequest;
import com.ntt.demo.domain.repositories.ConfigRepository;
import com.ntt.demo.domain.services.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigRepository configRepository;

    @Value("${depreciation.default.value}")
    private double defaultDepreciation;

    @Value("${depreciation.default.hours}")
    private int defaultDepreciationHours;

    @Override
    public List<ConfigDto> getAllConfigs() {
        return configRepository.getAllConfigs();
    }

    @Override
    public ConfigDto saveConfig(ConfigRequest configRequest) {
        ConfigDto configDto = new ConfigDto();
        configDto.setDepreciation(configRequest.getDepreciation());
        configDto.setDepreciationHours(configRequest.getDepreciationHours());

        return configRepository.saveConfig(configDto);
    }

    @Override
    public ConfigDto getActualConfig() {
        return configRepository.getActualConfig()
                .orElse(new ConfigDto(null, defaultDepreciation, defaultDepreciationHours));
    }
}
