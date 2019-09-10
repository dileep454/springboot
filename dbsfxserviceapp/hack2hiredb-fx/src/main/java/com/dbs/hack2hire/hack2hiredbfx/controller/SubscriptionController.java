package com.dbs.hack2hire.hack2hiredbfx.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.hack2hire.hack2hiredbfx.model.UserSubscription;

@CrossOrigin
@RestController
public class SubscriptionController {

	
	@RequestMapping("/getSubsciption/{userId}")
	public List<UserSubscription> getSubscription(@PathVariable("userId") int userId){
		return null;
		
	}
	
}
