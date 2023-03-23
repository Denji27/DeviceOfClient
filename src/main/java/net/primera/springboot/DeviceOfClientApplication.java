package net.primera.springboot;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.github.javafaker.Faker;

import net.primera.springboot.entity.Device;

@SpringBootApplication // same as @SpringBootConfiguration @EnableAutoConfiguration @ComponentScan
@EnableJpaAuditing
public class DeviceOfClientApplication implements CommandLineRunner {
	@Autowired
	@PersistenceContext
	private EntityManager de;

	public static void main(String[] args) {
		SpringApplication.run(DeviceOfClientApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Faker faker = new Faker();
		for (int i=0; i<1; i++) {
			Device device = new Device();
			String msisdn = faker.random().toString();
			device.setMsisdn(msisdn);
			String imei = faker.random().toString();
			device.setImei(imei);
			long deviceId = faker.number().randomDigit();
			device.setDeviceId(deviceId);
			String mac = faker.number().toString();
			device.setMac(mac);
			String lat = faker.number().toString();
			device.setLat(lat);
			String lon = faker.number().toString();
			device.setLon(lon);
			String status = "identifying";
			device.setStatus(status);
			de.persist(device);
		}
		de.flush();
	}

}
