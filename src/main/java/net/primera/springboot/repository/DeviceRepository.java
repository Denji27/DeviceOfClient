package net.primera.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import net.primera.springboot.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Long>{
//	@Query(value ="SELECT device FROM Device id WHERE device.imei LIKE ?1", nativeQuery = true)
	List<Device> findAllByImei(String imei);
}
