package com.lti.airlines.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.airlines.dao.GenericDao;
import com.lti.airlines.entity.FlightPrice;


@Service
public class FlightPriceService {
	
	@Autowired
	private GenericDao genericDao;
	
	public void add(FlightPrice flightPrice) {
		genericDao.store(flightPrice);
	}

	public FlightPrice fetchById(int flightPriceId) {
		return genericDao.fetchById(FlightPrice.class, flightPriceId);
	}
	
	public List<FlightPrice> fetchAll() {
		return genericDao.fetchAll(FlightPrice.class);
	}
	

}
