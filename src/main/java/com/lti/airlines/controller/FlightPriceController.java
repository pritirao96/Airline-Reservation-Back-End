package com.lti.airlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.airlines.entity.FlightPrice;
import com.lti.airlines.service.FlightPriceService;

@RestController
public class FlightPriceController {
	
	@Autowired
	FlightPriceService flightPriceService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@CrossOrigin
	public String add(@RequestBody FlightPrice flightPrice) {
		flightPriceService.add(flightPrice);
		return "flight price entered";
	}

}
