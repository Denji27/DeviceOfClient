package net.primera.springboot.model;

import net.primera.springboot.entity.Device;

public class DtoMapper {
	public static DeviceDto toDeviceDto(Device device) {
		DeviceDto deD = new DeviceDto();
		deD.setId(device.getId());
		deD.setDeviceId(device.getDeviceId());
		deD.setImei(device.getImei());
		deD.setLat(device.getLat());
		deD.setLon(device.getLon());
		deD.setMac(device.getMac());
		deD.setMsisdn(device.getMsisdn());
		deD.setStatus(device.getStatus());
		return deD;	
	}
}
