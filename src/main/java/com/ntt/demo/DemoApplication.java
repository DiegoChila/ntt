package com.ntt.demo;

import com.ntt.demo.domain.dto.ConfigRequest;
import com.ntt.demo.domain.dto.DeviceRequest;
import com.ntt.demo.domain.services.ConfigService;
import com.ntt.demo.domain.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

	@Autowired
	private DeviceService deviceService;

	@Autowired
	private ConfigService configService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		ConfigRequest configRequest = new ConfigRequest(4.0, 1);

		DeviceRequest deviceRequest = new DeviceRequest("Laptop empresarial marca HP", "Laptop", 2578990.0);
		DeviceRequest deviceRequest1 = new DeviceRequest("Iphone 14 pro max 256 gb", "Iphone 14", 6800000.0);

		configService.saveConfig(configRequest);
		deviceService.saveDevice(deviceRequest);
		deviceService.saveDevice(deviceRequest1);
	}
}
