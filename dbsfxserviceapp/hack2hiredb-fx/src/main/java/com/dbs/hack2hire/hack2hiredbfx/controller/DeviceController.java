package com.dbs.hack2hire.hack2hiredbfx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.hack2hire.hack2hiredbfx.model.Device;
import com.dbs.hack2hire.hack2hiredbfx.repo.DeviceRepository;

@CrossOrigin
@RestController
public class DeviceController {
	
	@Autowired
	DeviceRepository deviceRepository;
	
	@PostMapping("/addDevice")
	public void addDevice(@RequestBody String key) {
		
		key=key.replaceAll("\"", "");
		deviceRepository.deleteAll();
		Device device=new Device();
		device.setId(1);
		device.setDeviceKey(key);
		deviceRepository.save(device);

		
	}
	

}
