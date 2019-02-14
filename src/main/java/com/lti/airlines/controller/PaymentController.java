package com.lti.airlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.airlines.entity.Payment;
import com.lti.airlines.entity.UserRegistration;
import com.lti.airlines.service.PaymentService;
import com.lti.airlines.service.UserRegistrationService;

@RestController
@CrossOrigin
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@RequestMapping(value = "/addUserPayment", method = RequestMethod.POST)
	public String addUser(@RequestBody Payment payment) {
		paymentService.add(payment);
		return "Payment table updated";
	}

}
