package com.dbs.hack2hire.hack2hiredbfx.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TransferController {

	@RequestMapping("/transfer")
	public String transfer() {
		String randomuuid = java.util.UUID.randomUUID().toString();
		return "Your tarnsaction was successful with transaction ID : "+ randomuuid;
		
	}
}
