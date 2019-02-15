package com.lti.airlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airlines.dao.GenericDao;
import com.lti.airlines.dto.FlightDTO;
import com.lti.airlines.entity.Flight;

@Service
public class AdminService {

	@Autowired
	private GenericDao genericDao;

	@Transactional
	public void addFlight(FlightDTO flightDto) {
		System.out.println("In dao addflight");
		genericDao.store(flightDto);

	}

	@Transactional
	public void deleteFlight(int flightNumber) {

		genericDao.delete(Flight.class, flightNumber);

	}
//
//	@Transactional
//	public void add(AdminLogin adminLogin) {
//		System.out.println("In daoadminlogin");
//		genericDao.store(adminLogin);
//	}

}
