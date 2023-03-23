package net.primera.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.primera.springboot.entity.Device;
import net.primera.springboot.model.DeviceDto;
import net.primera.springboot.service.DeviceService;

@RestController

@RequestMapping(value = "/device")
public class DeviceController {
	private DeviceService devSer;
	
	public DeviceController(DeviceService devSer) {
		this.devSer=devSer;
	}
	
	@PostMapping("/register")
	public ResponseEntity<DeviceDto> saveClientDeviceInfo(@RequestBody Device device){
		DeviceDto device1 = devSer.saveClientDeviceInfo(device);
		return ResponseEntity.status(HttpStatus.CREATED).body(device1);
	}
	
	@GetMapping("/list")
	public ResponseEntity<ArrayList<DeviceDto>> getAllDevice(){
		return ResponseEntity.status(HttpStatus.OK).body(devSer.getAllDevice());
	}
	
	@GetMapping("/list/{imei}")
	public ResponseEntity<List<Device>> getByImei(@PathVariable("imei") String imei){
		List<Device> listByImei = devSer.getByImei(imei);
		return ResponseEntity.status(HttpStatus.OK).body(listByImei);
	}
	
	@PutMapping("/registered/{deviceId}")
	public ResponseEntity<Device> identifiedDevice(@PathVariable("deviceId") long deviceId){
		Device device = devSer.identifiedDevice(deviceId);
		return ResponseEntity.status(HttpStatus.OK).body(device);
	}
	@DeleteMapping("/delete/{deviceId}")
	public ResponseEntity<?> deleteDevice(@PathVariable("deviceId") long deviceId){
		return ResponseEntity.status(HttpStatus.OK).body(devSer.deleteByDeviceId(deviceId));
	}
}
