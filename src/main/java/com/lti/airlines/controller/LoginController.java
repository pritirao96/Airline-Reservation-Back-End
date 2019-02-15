package com.lti.airlines.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.airlines.entity.AdminLogin;
import com.lti.airlines.entity.Flight;
import com.lti.airlines.entity.UserRegistration;
import com.lti.airlines.service.LoginService;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(path = "/user/verify", method = RequestMethod.POST)
	public boolean userLogin(@RequestBody UserRegistration userRegistration) {
		boolean flag = loginService.verifyUser(userRegistration);
		//String flag1 = Boolean.toString(flag);
		if (flag) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping(path = "/admin/verify", method = RequestMethod.POST)
	public boolean adminLogin(@RequestBody AdminLogin adminLogin) {
		boolean flag = loginService.verifyAdmin(adminLogin);
		if (flag) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping(path = "/flight/{source}/{destination}/{date}", method = RequestMethod.GET)
	public List<Flight> searchFlight(@PathVariable("source") String src, @PathVariable("destination") String dst,
			@PathVariable("date") Date date) {
		return loginService.searchFlight(src, dst, date);
	}

	@CrossOrigin
	@RequestMapping(path = "/flight", method = RequestMethod.GET)
	public List<Flight> listFlight() {
		return loginService.listFlight();
	}
}
