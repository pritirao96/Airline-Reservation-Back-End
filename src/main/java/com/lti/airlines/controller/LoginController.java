package com.lti.airlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.airlines.entity.UserRegistration;
import com.lti.airlines.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

@RequestMapping(path="/verify",method=RequestMethod.POST)
public void login(@RequestBody UserRegistration userRegistration) {
	boolean flag=loginService.verify(userRegistration);
	String flag1=Boolean.toString(flag);
	if(flag1.equals("true")) {
	System.out.println("Verified");
	//return flag1;	
}
	else {
		System.out.println("Invalid login");
	}
}
}
