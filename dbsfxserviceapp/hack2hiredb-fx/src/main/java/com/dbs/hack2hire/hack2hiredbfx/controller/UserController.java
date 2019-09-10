package com.dbs.hack2hire.hack2hiredbfx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.hack2hire.hack2hiredbfx.model.User;
import com.dbs.hack2hire.hack2hiredbfx.repo.UserRepository;

@CrossOrigin
@RestController
public class UserController {
	
//	@Autowired
//	private UserRepository userRepository;
	
	@RequestMapping("/isUserPresent/{userName}")
	public boolean checkUser(@PathVariable("userName") String userName) {
		//
		User user;
		if(userName == "pankaj@kfld")
			return true;
		
		else
			return false;
	}
	
	
	@RequestMapping("/addUser")
	public String adduser(@RequestBody User user) {
		//add user successful
		if(1==1)
		return "User Added successfully";
		else
			return "User Already Exists";
		
		
	}
	

}
