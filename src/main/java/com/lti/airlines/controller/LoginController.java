package com.lti.airlines.controller;

import java.text.ParseException;
import java.util.Date;
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
import com.lti.airlines.objectEnum.Status;
import com.lti.airlines.service.LoginService;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(path = "/user/verify", method = RequestMethod.POST)
	public Object userLogin(@RequestBody UserRegistration userRegistration) {
		String flag = loginService.verifyUser(userRegistration);
		//String flag1 = Boolean.toString(flag);
		if (flag.equals("true")) {
			return "true";
		} else {
			return "false";
		}
	}

	@RequestMapping(path = "/admin/verify", method = RequestMethod.POST)
	public Object adminLogin(@RequestBody AdminLogin adminLogin) {
		boolean flag = loginService.verifyAdmin(adminLogin);
		if (flag) {
			return "true";
		} else {
			return "false";
		}
	}

	@RequestMapping(path = "/flight/{source}/{destination}/{date}", method = RequestMethod.GET)
	public List<Flight> searchFlight(@PathVariable("source") String src, @PathVariable("destination") String dst,
			@PathVariable("date") String date) throws ParseException {
		return loginService.searchFlight(src, dst, date);
	}

	@CrossOrigin
	@RequestMapping(path = "/flight", method = RequestMethod.GET)
	public List<Flight> listFlight() {
		return loginService.listFlight();
	}
}
