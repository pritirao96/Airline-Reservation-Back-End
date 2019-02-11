package com.lti.airlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.airlines.entity.UserRegistration;
import com.lti.airlines.service.UserRegistrationService;

@RestController
public class UserRegistrationController {
	
	@Autowired
	UserRegistrationService userRegistrationService;
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@CrossOrigin
	public String addUser(@RequestBody UserRegistration userRegistration) {
		userRegistrationService.add(userRegistration);
		return "You have registered successfully";
	}
	
	@RequestMapping(value = "/userRegistration{id}", method = RequestMethod.GET)
	public UserRegistration fetchById(@PathVariable("id") int id) {
		return userRegistrationService.fetchById(id);
	}
}
