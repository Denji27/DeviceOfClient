package net.primera.springboot.service.impl;

import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import net.primera.springboot.entity.Device;
import net.primera.springboot.exception.DuplicateRecordException;
import net.primera.springboot.exception.NotFoundException;
import net.primera.springboot.model.DeviceDto;
import net.primera.springboot.model.DtoMapper;
import net.primera.springboot.repository.DeviceRepository;
import net.primera.springboot.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService{
	private DeviceRepository devRe;
	
	
	public DeviceServiceImpl(DeviceRepository devRe) {
		super();
		this.devRe=devRe;
	}
	
	private static ArrayList<DeviceDto> devicesDto = new ArrayList<DeviceDto>();

	public DeviceDto saveClientDeviceInfo(Device device) {
		for (Device device1 : devRe.findAll()) {
			if (device.getDeviceId() == device1.getDeviceId()) {
				throw new DuplicateRecordException("Error 400: Thiet bi nay da ton tai");
			}
		}
		device.setStatus("identifying");
		DeviceDto deD = DtoMapper.toDeviceDto(devRe.save(device));
		devicesDto.add(deD);
		return deD;
	}

	@Override
	public ArrayList<DeviceDto> getAllDevice() {
		return devicesDto;
	}

	@Override
	public Device identifiedDevice(long deviceId) {
		for (Device device : devRe.findAll()) {
			if (device.getDeviceId() == deviceId) {
				device.setStatus("active");
				devRe.save(device);
				return device;
			}	
		}
		throw new NotFoundException("Error 404: Thiet bi nay khong ton tai trong he thong");
	}

	@Override
	public List<Device> getByImei(String imei) {
		return devRe.findAllByImei(imei);
	}

	@Override
	public String deleteByDeviceId(long deviceId) {
		for (Device device : devRe.findAll()) {
			if (device.getDeviceId() == deviceId) {
				devRe.delete(device);
				return "Delete Successfully!!";
			}
		}
		throw new NotFoundException("Error 404: Thiet bi nay khong ton tai trong he thong");
		
	}
}
