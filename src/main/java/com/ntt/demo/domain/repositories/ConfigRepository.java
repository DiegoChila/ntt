package com.ntt.demo.domain.repositories;

import com.ntt.demo.domain.dto.ConfigDto;

import java.util.List;
import java.util.Optional;

public interface ConfigRepository {

    List<ConfigDto> getAllConfigs();
    Optional<ConfigDto> getActualConfig();
    ConfigDto saveConfig(ConfigDto configDto);
}
