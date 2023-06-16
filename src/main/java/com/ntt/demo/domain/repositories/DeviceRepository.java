package com.ntt.demo.domain.repositories;

import com.ntt.demo.domain.dto.DeviceDto;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository {
    List<DeviceDto> getAllDevices();
    Optional<DeviceDto> getDeviceBySerial(Long serialDevice);
    DeviceDto saveDevice(DeviceDto deviceDto);
    void deleteDevice(Long serialDevice);
}
