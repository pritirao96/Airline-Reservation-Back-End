package com.lti.airlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.airlines.dao.PaymentDao;
import com.lti.airlines.entity.Payment;
import com.lti.airlines.entity.UserRegistration;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentDao paymentDao;
	
	public void add(Payment payment) {
		paymentDao.add(payment);
	}

}
