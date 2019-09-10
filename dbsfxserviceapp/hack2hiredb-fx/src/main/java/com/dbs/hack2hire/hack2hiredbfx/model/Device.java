package com.dbs.hack2hire.hack2hiredbfx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="device")
public class Device {

	@Id
	@Column(name="id")
	int id;
	
	@Column(name="device_key")
	String deviceKey;

	public Device() {
		super();
	}

	public Device(int id, String deviceKey) {
		super();
		this.id = id;
		this.deviceKey = deviceKey;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeviceKey() {
		return deviceKey;
	}

	public void setDeviceKey(String deviceKey) {
		this.deviceKey = deviceKey;
	}
	
	
}
