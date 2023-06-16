package com.ntt.demo.domain.services;

import com.ntt.demo.domain.dto.DeviceDto;
import com.ntt.demo.domain.dto.DeviceRequest;
import com.ntt.demo.domain.exceptions.CustomHttpException;

import java.util.List;

public interface DeviceService {

    List<DeviceDto> getAllDevices();
    DeviceDto getDeviceBySerial(Long deviceSerial) throws CustomHttpException;
    DeviceDto saveDevice(DeviceRequest DeviceRequest);
    void updateDevice(DeviceDto deviceDto);
    void updateDevice(Long deviceSerial, DeviceRequest deviceRequest) throws CustomHttpException;
    void deleteDevice(Long deviceSerial) throws CustomHttpException;
}
