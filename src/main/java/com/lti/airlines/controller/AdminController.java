package com.lti.airlines.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.airlines.*;
import com.lti.airlines.dao.GenericDao;
import com.lti.airlines.entity.Flight;
import com.lti.airlines.service.AdminService;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
@RequestMapping(path="/addFlight",method=RequestMethod.POST)
	public void addFlight(@RequestBody Flight flight) {
	adminService.addFlight(flight);
	}
	
	@RequestMapping(path="/flight/{flightNumber}",method=RequestMethod.GET)
	public void deleteFlight(@PathVariable ("flightNumber") int flightNumber) {
		adminService.deleteFlight(flightNumber);
	}
	
//	@RequestMapping(path="/addAdmin",method=RequestMethod.POST)
//	public void addAdmin(@RequestBody AdminLogin adminLogin) {
//		adminService.add(adminLogin);	

}
