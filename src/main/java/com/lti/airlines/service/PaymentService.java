package com.lti.airlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.airlines.dao.GenericDao;
import com.lti.airlines.entity.Payment;

@Service
public class PaymentService {
	
	@Autowired
	private GenericDao genericDao;
	
	public void add(Payment payment) {
		genericDao.store(payment);
	}

}
