package net.primera.springboot.service;

import java.util.ArrayList;
import java.util.List;



import net.primera.springboot.entity.Device;
import net.primera.springboot.model.DeviceDto;


public interface DeviceService {
	DeviceDto saveClientDeviceInfo(Device device);
	ArrayList<DeviceDto> getAllDevice();
	Device identifiedDevice(long deviceId);
	List<Device> getByImei(String imei);
	String deleteByDeviceId(long deviceId);
}
