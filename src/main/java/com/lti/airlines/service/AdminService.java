package com.lti.airlines.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airlines.*;
import com.lti.airlines.dao.AdminDao;
import com.lti.airlines.dao.GenericDao;
import com.lti.airlines.entity.AdminLogin;
import com.lti.airlines.entity.Flight;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	private GenericDao genericDao;

	@Transactional
	public void addFlight(Flight flight) {
		System.out.println("In dao addflight");
		adminDao.addFlight(flight);

	}

	@Transactional
	public void deleteFlight(int flightNumber) {

		adminDao.deleteFlight(flightNumber);
		
		
		
	}

	@Transactional
	public void add(AdminLogin adminLogin) {
	System.out.println("In daoadminlogin");
		adminDao.add(adminLogin);
	}

}
