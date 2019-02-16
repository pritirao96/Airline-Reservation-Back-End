package com.lti.airlines.controller;

import javax.validation.Valid;

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
@CrossOrigin
public class UserRegistrationController {

	@Autowired
	UserRegistrationService userRegistrationService;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public Object addUser(@Valid @RequestBody UserRegistration userRegistration) {
		//System.out.println(userRegistration.getfName());
		Object obj= userRegistrationService.add(userRegistration);
		return obj;
	}

	@RequestMapping(value = "/userRegistration{id}", method = RequestMethod.GET)
	public UserRegistration fetchById(@PathVariable("id") int id) {
		return userRegistrationService.fetchById(id);
	}
}
