package com.lti.airlines.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.airlines.dto.LoginDTO;
import com.lti.airlines.dto.LoginStatusDTO;
import com.lti.airlines.entity.Flight;
import com.lti.airlines.service.LoginService;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(path = "/user/verify", method = RequestMethod.POST)
	public LoginStatusDTO userLogin(@RequestBody LoginDTO loginDto) {
		
		return loginService.verifyUser(loginDto);
	}

	@RequestMapping(path = "/admin/verify", method = RequestMethod.POST)
	public LoginStatusDTO adminLogin(@RequestBody LoginDTO loginDto) {
		
		return loginService.verifyAdmin(loginDto);
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
