package com.ntt.demo.persistence.mappers;

import com.ntt.demo.domain.dto.DeviceDto;
import com.ntt.demo.persistence.entities.DeviceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    DeviceDto toDeviceDto(DeviceEntity deviceEntity);

    List<DeviceDto> toDeviceDtoList(List<DeviceEntity> deviceEntityList);

    DeviceEntity toDeviceEntity(DeviceDto deviceDto);
}
