package com.ntt.demo.persistence.repositories;

import com.ntt.demo.domain.dto.ConfigDto;
import com.ntt.demo.domain.repositories.ConfigRepository;
import com.ntt.demo.persistence.cruds.ConfigCrudRepository;
import com.ntt.demo.persistence.entities.ConfigEntity;
import com.ntt.demo.persistence.mappers.ConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfigRepositoryImpl implements ConfigRepository {

    @Autowired
    private ConfigCrudRepository configCrudRepository;

    @Autowired
    private ConfigMapper configMapper;

    @Override
    public List<ConfigDto> getAllConfigs() {
        return configMapper.toConfigDtoList(
                (List<ConfigEntity>) configCrudRepository.findAll()
        );
    }

    @Override
    public Optional<ConfigDto> getActualConfig() {
        return configCrudRepository.findFirstByOrderByIdDesc()
                .map(c -> configMapper.toConfigDto(c));
    }

    @Override
    public ConfigDto saveConfig(ConfigDto configDto) {
        ConfigEntity configEntity = configMapper.toConfigEntity(configDto);
        return configMapper.toConfigDto(
                configCrudRepository.save(configEntity)
        );
    }
}
