package com.ntt.demo.domain.services.impl;

import com.ntt.demo.domain.dto.DeviceDto;
import com.ntt.demo.domain.dto.DeviceRequest;
import com.ntt.demo.domain.exceptions.CustomHttpException;
import com.ntt.demo.domain.repositories.DeviceRepository;
import com.ntt.demo.domain.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<DeviceDto> getAllDevices() {
        return deviceRepository.getAllDevices();
    }

    @Override
    public DeviceDto getDeviceBySerial(Long deviceSerial) throws CustomHttpException {
        return deviceRepository.getDeviceBySerial(deviceSerial)
                .orElseThrow(() -> new CustomHttpException("Dispositivo no encontrado", HttpStatus.NOT_FOUND));
    }

    @Override
    public DeviceDto saveDevice(DeviceRequest DeviceRequest) {
        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setDescription(DeviceRequest.getDescription());
        deviceDto.setName(DeviceRequest.getName());
        deviceDto.setPurchaseAmount(DeviceRequest.getPurchaseAmount());
        deviceDto.setPurchaseDate(LocalDateTime.now());
        deviceDto.setLastValueUpdate(LocalDateTime.now());
        deviceDto.setActualValue(DeviceRequest.getPurchaseAmount());

        return deviceRepository.saveDevice(deviceDto);
    }

    @Override
    public void updateDevice(DeviceDto deviceDto) {
        deviceRepository.saveDevice(deviceDto);
    }

    @Override
    public void updateDevice(Long deviceSerial, DeviceRequest deviceRequest) throws CustomHttpException {
        DeviceDto deviceDto = getDeviceBySerial(deviceSerial);

        deviceDto.setName(deviceRequest.getName());
        deviceDto.setDescription(deviceRequest.getDescription());

        if (!deviceRequest.getPurchaseAmount().equals(deviceDto.getPurchaseAmount())) {
            deviceDto.setPurchaseAmount(deviceRequest.getPurchaseAmount());
            deviceDto.setActualValue(deviceRequest.getPurchaseAmount());
        }

        deviceRepository.saveDevice(deviceDto);
    }

    @Override
    public void deleteDevice(Long deviceSerial) throws CustomHttpException {
        DeviceDto deviceDto = getDeviceBySerial(deviceSerial);
        deviceRepository.deleteDevice(deviceDto.getSerial());
    }
}
