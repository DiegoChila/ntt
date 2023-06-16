package com.ntt.demo.persistence.mappers;

import com.ntt.demo.domain.dto.ConfigDto;
import com.ntt.demo.persistence.entities.ConfigEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConfigMapper {

    ConfigDto toConfigDto(ConfigEntity configEntity);

    ConfigEntity toConfigEntity(ConfigDto configDto);

    List<ConfigDto> toConfigDtoList(List<ConfigEntity> configEntityList);
}
