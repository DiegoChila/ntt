package com.ntt.demo.domain.config;

import com.ntt.demo.domain.dto.ConfigDto;
import com.ntt.demo.domain.dto.DeviceDto;
import com.ntt.demo.domain.services.ConfigService;
import com.ntt.demo.domain.services.DeviceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ScheduleAmountUpdateTest {

    @Mock
    DeviceService deviceService;

    @Mock
    ConfigService configService;

    @InjectMocks
    ScheduleAmountUpdate scheduleAmountUpdate;

    @Test
    public void mustNotUpdateAnyDevice() {
        Mockito.when(configService.getActualConfig())
                .thenReturn(new ConfigDto(null, 4.0, 1));

        Mockito.when(deviceService.getAllDevices())
                .thenReturn(
                        List.of(
                                new DeviceDto(1L, "Test", "Dispositivo 1", LocalDateTime.now(), 1000.0, LocalDateTime.now(), 1000.0)
                        )
                );

        scheduleAmountUpdate.updateAmount();

        Mockito.verify(deviceService, Mockito.times(0))
                .updateDevice(ArgumentMatchers.any(DeviceDto.class));
    }

    @Test
    public void mustUpdateOneDevice() {
        Mockito.when(configService.getActualConfig())
                .thenReturn(new ConfigDto(null, 4.0, 1));

        Mockito.when(deviceService.getAllDevices())
                .thenReturn(
                        List.of(
                                new DeviceDto(1L, "Test", "Dispositivo 1", LocalDateTime.now(), 1000.0, LocalDateTime.now(), 1000.0),
                                new DeviceDto(1L, "Test", "Dispositivo 2", LocalDateTime.of(2023, 06, 15, 15, 30), 1000.0, LocalDateTime.of(2023, 06, 15, 15, 30), 1000.0)
                        )
                );

        scheduleAmountUpdate.updateAmount();

        Mockito.verify(deviceService, Mockito.times(1))
                .updateDevice(ArgumentMatchers.any(DeviceDto.class));
    }

    @Test
    public void mustUpdateTwoDevices() {
        Mockito.when(configService.getActualConfig())
                .thenReturn(new ConfigDto(null, 4.0, 1));

        Mockito.when(deviceService.getAllDevices())
                .thenReturn(
                        List.of(
                                new DeviceDto(1L, "Test", "Dispositivo 1", LocalDateTime.of(2023, 06, 15, 15, 30), 1000.0, LocalDateTime.of(2023, 06, 15, 15, 30), 1000.0),
                                new DeviceDto(1L, "Test", "Dispositivo 2", LocalDateTime.of(2023, 06, 15, 15, 30), 1000.0, LocalDateTime.of(2023, 06, 15, 15, 30), 1000.0)
                        )
                );

        scheduleAmountUpdate.updateAmount();

        Mockito.verify(deviceService, Mockito.times(2))
                .updateDevice(ArgumentMatchers.any(DeviceDto.class));
    }
}