package com.ntt.demo.web.controllers;

import com.ntt.demo.domain.dto.DeviceDto;
import com.ntt.demo.domain.dto.DeviceRequest;
import com.ntt.demo.domain.exceptions.CustomHttpException;
import com.ntt.demo.domain.services.DeviceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public ResponseEntity<List<DeviceDto>> getAllDevices() {
        return ResponseEntity.ok(deviceService.getAllDevices());
    }

    @GetMapping("/{deviceSerial}")
    public ResponseEntity<DeviceDto> getDeviceBySerial(@PathVariable("deviceSerial") Long deviceSerial) throws CustomHttpException {
        return ResponseEntity.ok(deviceService.getDeviceBySerial(deviceSerial));
    }

    @PostMapping
    public ResponseEntity<DeviceDto> saveDevice(@RequestBody @Valid DeviceRequest deviceRequest) {
        return new ResponseEntity<>(deviceService.saveDevice(deviceRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{deviceSerial}")
    public ResponseEntity<Object> updateDevice(@PathVariable("deviceSerial") Long deviceSerial, @RequestBody @Valid DeviceRequest deviceRequest) throws CustomHttpException {
        deviceService.updateDevice(deviceSerial, deviceRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{deviceSerial}")
    public ResponseEntity<Object> deleteDevice(@PathVariable("deviceSerial") Long deviceSerial) throws CustomHttpException {
        deviceService.deleteDevice(deviceSerial);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
