package com.ntt.demo.domain.config;

import com.ntt.demo.domain.dto.ConfigDto;
import com.ntt.demo.domain.services.ConfigService;
import com.ntt.demo.domain.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Duration;
import java.time.LocalDateTime;

@Configuration
@EnableScheduling
public class ScheduleAmountUpdate {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private ConfigService configService;

    @Scheduled(cron = "${cron.expression}")
    public void updateAmount() {
        System.out.println("Se ejecuta actualizar valor");
        ConfigDto configDto = configService.getActualConfig();

        LocalDateTime actualTime = LocalDateTime.now();
        long devicesUpdated = deviceService.getAllDevices().stream()
                .filter(d -> {
                    Duration duration = Duration.between(d.getLastValueUpdate(), actualTime);
                    return duration.toHours() >= configDto.getDepreciationHours();
                })
                .peek(d -> {
                    double amount = d.getActualValue() * ((100 - configDto.getDepreciation()) / 100);
                    d.setActualValue(amount);
                    d.setLastValueUpdate(LocalDateTime.now());
                    deviceService.updateDevice(d);
                })
                .count();

        System.out.println(
                (devicesUpdated > 0) ? "Se actualizaron " + devicesUpdated + " dispositivos"
                : "No se actualizacion dispositivos"
        );
    }
}
