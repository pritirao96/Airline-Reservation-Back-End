package com.lti.airlines.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.airlines.entity.FlightPrice;
import com.lti.airlines.entity.UserRegistration;
import com.lti.airlines.service.FlightPriceService;
import com.lti.airlines.service.UserRegistrationService;

@RestController
public class FlightPriceController {
	
	@Autowired
	FlightPriceService flightPriceService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@CrossOrigin
	public String add(@RequestBody FlightPrice flightPrice) {
		System.out.println("the servie class will be called now");
		flightPriceService.add(flightPrice);
		return "flight price entered";
	}

//	@RequestMapping(value = "/flightPrice/{flightPriceId}", method = RequestMethod.GET)
//	public FlightPrice fetchById(@PathVariable("flightPriceId") int flightPriceId) {
//		return flightPriceService.fetchById(flightPriceId);
//	}

}
