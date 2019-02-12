package com.lti.airlines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.airlines.entity.AdminLogin;
import com.lti.airlines.entity.Flight;
import com.lti.airlines.entity.UserRegistration;
import com.lti.airlines.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(path="/user/verify",method=RequestMethod.POST)
	public void userLogin(@RequestBody UserRegistration userRegistration) {
		boolean flag=loginService.verifyUser(userRegistration);
		String flag1=Boolean.toString(flag);
		if(flag1.equals("true")) {
			System.out.println("Verified");
	//return flag1;	
		}
		else {
			System.out.println("Invalid login");
		}
	}
	
	@RequestMapping(path="/admin/verify",method=RequestMethod.POST)
	public void adminLogin(@RequestBody AdminLogin adminLogin) {
		boolean flag=loginService.verifyAdmin(adminLogin);
		String flag1=Boolean.toString(flag);
		if(flag1.equals("true")) {
			System.out.println("Verified");
	//return flag1;	
		}
		else {
			System.out.println("Invalid login");
		}
	}
	
	@RequestMapping(path="flight/{source}/{destination}",method=RequestMethod.GET)
	public List<Flight> searchFlight(@PathVariable("source")String src,@PathVariable("destination")String dst){
		return loginService.searchFlight(src, dst);
	}
}
