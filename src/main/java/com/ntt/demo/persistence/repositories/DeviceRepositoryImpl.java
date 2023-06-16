package com.ntt.demo.persistence.repositories;

import com.ntt.demo.domain.dto.DeviceDto;
import com.ntt.demo.domain.repositories.DeviceRepository;
import com.ntt.demo.persistence.cruds.DeviceCrudRepository;
import com.ntt.demo.persistence.entities.DeviceEntity;
import com.ntt.demo.persistence.mappers.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DeviceRepositoryImpl implements DeviceRepository {

    @Autowired
    private DeviceCrudRepository deviceCrudRepository;

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public List<DeviceDto> getAllDevices() {
        return deviceMapper.toDeviceDtoList(
                (List<DeviceEntity>) deviceCrudRepository.findAll()
        );
    }

    @Override
    public Optional<DeviceDto> getDeviceBySerial(Long serialDevice) {
        return deviceCrudRepository.findById(serialDevice)
                .map(d -> deviceMapper.toDeviceDto(d));
    }

    @Override
    public DeviceDto saveDevice(DeviceDto deviceDto) {
        DeviceEntity deviceEntity = deviceMapper.toDeviceEntity(deviceDto);
        return deviceMapper.toDeviceDto(
                deviceCrudRepository.save(deviceEntity)
        );
    }

    @Override
    public void deleteDevice(Long serialDevice) {
        deviceCrudRepository.deleteById(serialDevice);
    }
}
